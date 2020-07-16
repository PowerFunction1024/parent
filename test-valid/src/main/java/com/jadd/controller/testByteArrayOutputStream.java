package com.jadd.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2020/7/7
 */
public class testByteArrayOutputStream {

    public static void main(String[] args) throws FileNotFoundException {
        save("te.txt","",new FileInputStream("D:\\testIO\\aaa.txt"));

    }
    public static boolean save(String filename, String contentType, InputStream is) {
        try {
            int available = is.available();
            System.out.println(available);
            byte[] bytes = new byte[is.available()];
            System.out.println(bytes.length);
            is.read(bytes);


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] data = baos.toByteArray();
            Files.write(Paths.get("D:\\testIO", filename), data);
            is.close();
            baos.close();
            return true;
        } catch (IOException e) {
            System.out.println("错误");
            return false;
        }
    }

    public void method(){
    }

}
