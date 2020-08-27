package com.jadd.controller;

import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2020/8/27
 */
public class testpdftoimage {

    @SneakyThrows
    public static void main(String[] args) {
        //convertPdf2Image("C:\\Users\\Administrator\\Desktop\\test\\债权收购暨债务重组协议之补充协议-信粤-A-2017-002-24.pdf",
        //        "C:\\Users\\Administrator\\Desktop\\test");
        getImgInPDF("C:\\Users\\Administrator\\Desktop\\test\\债权收购暨债务重组协议之补充协议-信粤-A-2017-002-24.pdf",
                "C:\\Users\\Administrator\\Desktop\\test\\");

    }


    public static void convertPdf2Image(String pdfFilePath,String imageFilePath)
            throws IOException
    {
        //File pdfFile = new File(pdfFilePath);
        //File imageFile = new File(imageFilePath);
        //File imageFileParent = new File(imageFile.getParent());
        //OutputStream output = null;
        //PDDocument pdDoc = null;
        //List<File> files = new ArrayList<File>();
        //try{
        //    if(pdfFile.exists()){
        //        if(!imageFileParent.exists()){
        //            imageFileParent.mkdirs();
        //        }
        //        pdDoc = PDDocument.load(pdfFile);
        //        int pageCount = pdDoc.getNumberOfPages();
        //        List pages = pdDoc.getDocumentCatalog().getAllPages();
        //        for(int i = 0; i < pages.size(); i++){
        //            PDPage page = (PDPage)pages.get(i);
        //            BufferedImage image = page.convertToImage();
        //            Iterator iter = ImageIO.getImageWritersBySuffix("jpg");
        //            ImageWriter writer = (ImageWriter)iter.next();
        //            File tempFile = new File(imageFileParent.getPath(),i+imageFile.getName());
        //            files.add(tempFile);
        //            output = new FileOutputStream(tempFile);
        //            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
        //            writer.setOutput(imageOut);
        //            writer.write(new IIOImage(image,null,null));
        //            output.close();
        //        }
        //        pdDoc.close();
        //    }

    //    }finally{
    //        try{
    //            if(pdDoc != null){
    //                pdDoc.close();
    //            }
    //            if(output != null){
    //                output.close();
    //            }
    //        }catch(IOException e){
    //            e.printStackTrace();
    //        }
    //    }
    }


    /**
     * pdf 转换为图片
     * @param pdfPath　pdf文件路径
     * @param imgPath　图片导出目标路径
     */
    public static void getImgInPDF(String pdfPath,String imgPath){
        PDDocument document = null;
        try {
            File pdfFile = new File(pdfPath);
            //　加载pdf文档，在pdmodel包
            document = PDDocument.load(pdfFile);
            //　PDF文档总页数
            //System.out.println("共 "+num+" 页.");
            //　PDF文档渲染对象，在rendering包
            PDFRenderer renderer = new PDFRenderer(document);

            //String startDate = DateTool.now();
            int pageCount = document.getNumberOfPages();
            System.out.println("共 "+pageCount+" 页.");
            for (int i = 0; i < pageCount; i++) {
                /**
                 * renderImage(i,1.9f)
                 *
                 * i: 指定页对象下标,从0开始,0即第一页
                 *
                 * 1.9f:DPI值(Dots Per Inch),官方描述比例因子，其中1=72 DPI
                 *      DPI是指每英寸的像素,也就是扫描精度,DPI越低,扫描的清晰度越低
                 *      根据根据自己需求而定,我导出的图片是 927x1372
                 */
                BufferedImage image = renderer.renderImage(i,2.5f);
                // 导出图片命名为:0-n.jpeg
                ImageIO.write(image, "JPEG", new File(imgPath+i+".jpg"));
                System.out.println("导出 "+imgPath+i+".jpg...");
            }
            //System.out.println("开始时间:"+startDate);
            //System.out.println("结束时间:"+ DateTool.now());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
