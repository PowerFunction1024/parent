package com.jadd;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/5/24
 */
public class FreemarkerDemo {
    @Test
    public void helloWord() throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //指定模板文件的来源
        String path = FreemarkerDemo.class.getClassLoader().getResource("template").getPath();
        System.out.println("=========="+path);
        cfg.setDirectoryForTemplateLoading(new File(path));
        //这是模板的编码
        cfg.setDefaultEncoding("UTF-8");
        //获取模板
        Template template = cfg.getTemplate("helloworld.ftl");
        //创建FreeMarker的数据模型
        Map<String,String> root = new HashMap<String,String>();
        root.put("who","freemarker");
        //这是输出文件
        File file = new File("D://" +"helloWord.html");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        //将模板与数据模型合并
        template.process(root, out);
        out.flush();
        out.close();
    }

}
