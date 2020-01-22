package com.jadd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jadd.been.User;
import com.jadd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/1/9
 */
@RestController
@RequestMapping("/test")
public class Test01 {

    @Autowired(required = false)
    private UserMapper userMapper;

    @GetMapping("/method01")
    public List<User>  method01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1088248166370832385L);

        List<User> users = userMapper.selectList(queryWrapper);
        return  users;
    }

    @GetMapping("/method02")
    public List<User>  method02(){
        User user = new User();
        user.setAge(25).setName("王");
        List<User> users = userMapper.selectByCondition(user);

        return  users;
    }


}
