package com.jadd.controller;

import com.jadd.been.User;
import com.jadd.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : _xu_
 * @desc :  测试实际项目中使用service,这样就不用注入mapper了
 * @date : 2020/4/5
 */
@RestController
@RequestMapping("/test")
public class TestService {

    @Resource
    private UserService userService;
    @GetMapping("/testService01")
    public List<User> testService01(){
         userService.test01();
        return  null;
    }

    @GetMapping("/testService02")
    public List<User> testService02(){
         userService.test02();
        return  null;
    }

}
