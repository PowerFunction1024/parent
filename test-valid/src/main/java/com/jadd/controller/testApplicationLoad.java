package com.jadd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/8/23
 */
@RestController
@RequestMapping("/testApplicationLoad")
public class testApplicationLoad {

    //@Value("${aa.bb}")
    private String bb;
    public String  method01(){
        return bb;
    }

}
