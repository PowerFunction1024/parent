package com.jadd.controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author : Administrator
 * @desc : 生成水印的透明图片
 * @date : 2021/2/5
 */
public class TestAddWatermark {
    public static void main(String[] args) {

        addWatermark("/img/A4.png", "E:\\img\\A4addWatermark03.png", "繁华似锦");
    }

    private static void addWatermark(String sourceImgPath, String tarImgPath, String waterMarkContent) {
        OutputStream outputStream = null;
        BufferedImage bufImg = null;
        Graphics2D g = null;

        try {
            //纯粹是为了获取A4纸的宽度和高度
            InputStream a4pngInputStream = Object.class.getResourceAsStream(sourceImgPath);
            BufferedImage srcImg = ImageIO.read(a4pngInputStream);
            int srcImgHeight = srcImg.getHeight(null);
            int srcImgWidth = srcImg.getWidth(null);
            //生成图片
            bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            g = bufImg.createGraphics();
            // ----------  设置图片透明start  -----------------
            bufImg = g.getDeviceConfiguration()
                    .createCompatibleImage(794, 1123, Transparency.TRANSLUCENT);
            g.dispose();
            g = bufImg.createGraphics();
            // ----------  设置图片透明end  -----------------

            //设置水印字体
            //Font font = new Font("宋体", Font.PLAIN, 32);
            //粗体设置
            Font font = new Font("宋体", Font.BOLD, 32);
            //水印透明度  alpha->透明
            float alpha = 0.2f;
            //水印旋转角度
            Integer degree = -30;
            //水印的颜色
            Color color = new Color(0, 0, 0);
            g.setFont(font);
            g.setColor(color);
            //设置要渲染的水印文字位置规则 和 透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha)); 用于不是透明的图片时
            //传参是倾斜的弧度
            g.rotate(Math.toRadians(degree));
            //文本抗锯齿
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            //边缘抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            JLabel label = new JLabel(waterMarkContent);
            FontMetrics fontMetrics = label.getFontMetrics(font);
            //文字水印的宽
            int width = fontMetrics.stringWidth(label.getText());
            //打印的行数
            int rowsNumber = srcImgHeight / width;
            //每行打印的列数
            int columnsNumber = srcImgWidth / width;
            //至少打印一次
            if (rowsNumber < 1) {
                rowsNumber = 1;
            }
            if (columnsNumber < 1) {
                columnsNumber = 1;
            }
            //for (int j = 0; j < rowsNumber + 2; ) {
            //    for (int i = 0; i < columnsNumber; i++) {
            //        //画出水印的位置
            //        g.drawString(waterMarkContent,
            //                ((-j - 1) * width + i * width * 2 + width * 2),
            //                j * width + width);
            //    }
            //    j += 2;
            //}

            for (int j = 0; j < rowsNumber; ) {
                for (int i = 0; i < columnsNumber; i++) {
                    //画出水印的位置
                    g.drawString(waterMarkContent,
                            (-j * width + i * width * 2 + width * 2),
                            j * width + i * width * 2);
                }
                j += 2;
            }
            //释放资源
            g.dispose();

            Font font2 = new Font("宋体", Font.BOLD, 30);
            Graphics2D g2 = (Graphics2D) bufImg.getGraphics();
            g2.setFont(font2);
            g2.setPaint(Color.black);
            //文本抗锯齿
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            //边缘抗锯齿
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawString("2021-02-03-zhongguo-深圳", 300, 30);
            g2.dispose();


            FileOutputStream tarOutputStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "png", tarOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
