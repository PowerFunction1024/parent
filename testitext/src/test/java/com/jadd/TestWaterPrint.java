package com.jadd;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestWaterPrint {
	public static void main(String[] args) throws DocumentException,
			IOException {
		// 要输出的pdf文件
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\testPdfAdd\\aa\\北京嘉铭债权收购协议copy.pdf")));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 将pdf文件先加水印然后输出
		setWatermark(bos, "D:\\testPdfAdd\\aa\\北京嘉铭债权收购协议.pdf", format.format(cal.getTime())
				+ "  下载使用人：" + "测试user", 16);
	}
 
	public static void setWatermark(BufferedOutputStream bos, String input,
			String waterMarkName, int permission) throws DocumentException,
			IOException {
		PdfReader reader = new PdfReader(input);
		PdfStamper stamper = new PdfStamper(reader, bos);
		int total = reader.getNumberOfPages() + 1;
		PdfContentByte content;
		BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);
		PdfGState gs = new PdfGState();
		for (int i = 1; i < total; i++) {
			content = stamper.getOverContent(i);// 在内容上方加水印
		    //content = stamper.getUnderContent(i);//在内容下方加水印
			gs.setFillOpacity(0.2f);
			// content.setGState(gs);
			content.beginText();
			//content.setColorFill(Color.LIGHT_GRAY);
			content.setFontAndSize(base, 50);
			content.setTextMatrix(70, 200);
			//content.showTextAligned(Element.ALIGN_CENTER, "公司内部文件，请注意保密！", 300,350, 55);
			Image image = Image.getInstance("D:\\testPdfAdd\\aa\\tu12013647678.png");
			/*img.setAlignment(Image.LEFT | Image.TEXTWRAP);
			img.setBorder(Image.BOX);
			img.setBorderWidth(10);
			img.setBorderColor(BaseColor.WHITE);
			img.scaleToFit(1000, 72);//大小
			img.setRotationDegrees(-30);//旋转 */
			image.setAbsolutePosition(0, 0); // set the first background image of the absolute
			//image.scaleToFit(400,400);
			image.scalePercent(100F);
			content.addImage(image);
			//content.setColorFill(Color.BLACK);
			content.setFontAndSize(base, 8);
			content.showTextAligned(Element.ALIGN_CENTER, "下载时间："
					+ waterMarkName + "", 300, 10, 0);
			content.endText();
 
		}
		stamper.close();
	}

}