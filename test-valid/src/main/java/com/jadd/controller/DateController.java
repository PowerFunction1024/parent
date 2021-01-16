package com.jadd.controller;

import com.jadd.been.DateVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/10/24
 */
@RestController
@RequestMapping("/date")
public class DateController {


    @RequestMapping("/test")
    public DateVo test(DateVo dateVo){
        System.out.println(dateVo.getDate());

        System.out.println("========================");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(dateVo.getDate());
        System.out.println(format);
        return dateVo;

    }

    @RequestMapping("/test01")
    public DateVo test01(DateVo dateVo){

        DateVo vo = new DateVo();
        vo.setDate(new Date());
        return vo;

    }

}
