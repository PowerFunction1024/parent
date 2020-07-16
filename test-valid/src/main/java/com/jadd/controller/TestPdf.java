package com.jadd.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSONObject;
//import org.kg.bouncycastle.util.encoders.Base64;

public class TestPdf {

	public static void main(String[] args) throws IOException {
		String url = "http://127.0.0.1:8080/Docs/convert2pdf";
		String contentType = "application/ms-word";
		HttpURLConnection connection = null;
		try{
			URL objUrl = new URL(url);
			connection = (HttpURLConnection) objUrl.openConnection(); 
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			/**
			 * doc/docx : application/ms-word
			 * xls/xlsx : application/ms-excel
			 * html/htm : text/html             单页面，没有另外的css\img图片链接。
			 * ofd      : application/ofd
			 *            
			 * 
			 * URL路径/图片转PDF：application/json
			 * 					URL路径
			 *                  { 
			 *                    "docType" : "HTML",
			 *                    "url":"http://127.0.0.1/index.html"
			 *                  }
			 *                  
			 *                  图片转PDF:支持png、jpg、jpeg、git、bmp等格式图片
			 *                  { 
			 *                    "docType" : "IMAGE",
			 *                    "images":["imagedata base64编码","imagedata base64编码"]  
			 *                  }
			 */
			connection.setRequestProperty("Content-Type", contentType);
			connection.connect();
			
			if("application/json".equals(contentType)){
				JSONObject obj = new JSONObject();
				obj.put("docType", "HTML");
				obj.put("url", "http://www.sohu.com");
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(obj.toString().getBytes("UTF-8"));
				IOUtils.copy(byteArrayInputStream, connection.getOutputStream());
			} else {
				FileInputStream fileInputStream =  null;
				try{
					fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ocr2\\ocr测试文件-cj\\信达测试合同数据-cj\\1合作总协议模板修改内容OCR测试.docx");
					IOUtils.copy(fileInputStream, connection.getOutputStream());
				} finally {
					IOUtils.closeQuietly(fileInputStream);
				}
			}
			int code = connection.getResponseCode();
			if(code == 200){
				InputStream in = connection.getInputStream();
				IOUtils.copy(in, new FileOutputStream("d:/docsTmp.pdf"));
				System.out.println("转换成功！");
			} else {
				//System.out.println(getResponseErrMessage(connection));
			}
		} finally {
			if(connection != null) connection.disconnect();
		}
	}
	
	//
	//public static String getResponseErrMessage(HttpURLConnection connection){
	//	String ret = null;
	//	Map<String,String> map = new HashMap<>();
	//	for(int i=0;;i++){
	//		 String mine = connection.getHeaderField(i);
	//         if (mine == null) break;
	//         map.put(connection.getHeaderFieldKey(i),mine);
	//	}
	//	String message = map.get("Message");
	//	try {
	//		ret = new String(Base64.decode(message),"UTF-8");
	//	} catch (UnsupportedEncodingException e) {
	//	}
	//	return ret;
	//}

}
