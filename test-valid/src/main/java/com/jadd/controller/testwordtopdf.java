package com.jadd.controller;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2020/7/8
 */
public class testwordtopdf {


        public static void main(String[] args) {
            doc2pdf("C:\\Users\\Administrator\\Desktop\\ocr2\\ocr测试文件-cj\\信达测试合同数据-cj\\3债权收购协议（XX-A-2018-00X）.doc","D:\\3test.pdf");
        }
        public static void doc2pdf(String inPath, String outPath) {
            FileOutputStream os =null;
            try {
                File file = new File(outPath); // 新建一个空白pdf文档
                os = new FileOutputStream(file);
                Document doc = new Document(inPath); // Address是将要被转化的word文档
                doc.save(os, SaveFormat.PDF);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
