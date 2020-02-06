package com.jadd.controller;

import com.jadd.been.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/1/15
 */
@RestController
@RequestMapping("/user")
public class TestValid {
    @PostMapping
    public User create(@RequestBody @Valid User user) {
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        user.setId("1");
        return user;
    }

}
