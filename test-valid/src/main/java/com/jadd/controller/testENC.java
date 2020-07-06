package com.jadd.controller;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2020/7/6
 */
public class testENC {
    public static void main(String[] args) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("这个一般在配置文件中配置");
        System.out.println(basicTextEncryptor.encrypt("root"));
    }
}
