package com.jadd.controller;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2020/5/26
 */
@RestController
@RequestMapping("test")
public class testHtmlToPDF {
    private static final String TEMPLATE = "D:\\code\\parent\\freemarker\\src\\main\\resources\\template\\";//模板存储路径
    private static final String CONTRACT = "D:\\pdf\\";


    private static final String PDFNAME = "pdfDemo";//pdf文件名
    private static final String HTMLNAME = "test01";//html文件名

    @RequestMapping("htmlToPdf")
    public String htmlToPdf() throws Exception {
        try {
            //		这里是选择某个模板
            String templateName = "test01";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            //这里是给具体的某些字段赋值
            paramMap.put("ZJHKZH", "271003********279975");
            paramMap.put("KYYE", "79244.95");
            paramMap.put("LXFS", "配置web.xml中LXFS属性，例如(张小凡，123,4567,8909)");
            paramMap.put("KHWD", "123");
            paramMap.put("CSKSRQ", "2016年10月31日00时00分");
            paramMap.put("KSRQ", "2017-03-14");
            paramMap.put("YE","94444.95");
            paramMap.put("KHZH","271**********07279975");
            paramMap.put("AH", "(2015)****字第0***0号");
            paramMap.put("CKH", "(2017)法YH****9控字第*号");
            paramMap.put("YDJAH", "(2015)***执字第00020号");
            paramMap.put("KZCS", "01");
            paramMap.put("XM", "秀不行不行的。哈哈哈哈！！");
            paramMap.put("FYMC", "****人民法院");
            paramMap.put("JSRQ", "2017-06-14");
            paramMap.put("KZZT", "1");
            paramMap.put("SE", "100");
            paramMap.put("LCZH", "987234234");
            paramMap.put("DATE", "2017年03月24日09时39分");
            paramMap.put("CKWH", "(2015)*****字第0**20-1**0号裁定书");
            paramMap.put("SKSE", "100");
            paramMap.put("CSJSRQ", "2016年10月31日 00时00分");
            paramMap.put("questionMainOrder","ygc");
            paramMap.put("standardScore","sunny");
            //调用具体的实现方法
            contractHandler(templateName, paramMap);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    public static void contractHandler(String templateName,
                                       Map<String, Object> paramMap) throws Exception {
            // 获取本地模板存储路径、合同文件存储路径
            String templatePath = TEMPLATE;
            String contractPath = CONTRACT;
            // 组装html和pdf合同的全路径URL
            String localHtmlUrl = contractPath + HTMLNAME + ".html";
            String localPdfPath = contractPath + "/";
            // 判断本地路径是否存在如果不存在则创建
            File localFile = new File(localPdfPath);
            if (!localFile.exists()) {
                localFile.mkdirs();
            }
            String localPdfUrl = localFile + "/" + PDFNAME + ".pdf";
            templateName = templateName + ".ftl";
            htmHandler(templatePath, templateName, localHtmlUrl, paramMap);// 生成html合同
            pdfHandler(localHtmlUrl, localPdfUrl);// 根据html合同生成pdf合同
            deleteFile(localHtmlUrl);// 删除html格式合同

            System.out.println("PDF生成成功");
    }


    private static void htmHandler(String templatePath, String templateName,
                                   String htmUrl, Map<String, Object> paramMap) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(templatePath));

        Template template = cfg.getTemplate(templateName);

        File outHtmFile = new File(htmUrl);

        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outHtmFile)));
        template.process(paramMap, out);

        out.close();
    }


    private static void pdfHandler(String htmUrl, String pdfUrl)
            throws DocumentException, IOException {
        File htmFile = new File(htmUrl);
        File pdfFile = new File(pdfUrl);

        String url = htmFile.toURI().toURL().toString();

        OutputStream os = new FileOutputStream(pdfFile);


        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);

        org.xhtmlrenderer.pdf.ITextFontResolver fontResolver = renderer
                .getFontResolver();
        // 解决中文支持问题
//		fontResolver.addFont(TEMPLATE+"simsun.ttc",
//				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        try {
            fontResolver.addFont(TEMPLATE + "simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (com.itextpdf.text.DocumentException e) {
            e.printStackTrace();
        }

        renderer.layout();
        try {
            renderer.createPDF(os);
        } catch (com.itextpdf.text.DocumentException e) {
            e.printStackTrace();
        }
        os.close();
    }

    private static void deleteFile(String fileUrl) {
        File file = new File(fileUrl);
        file.delete();
    }


}
