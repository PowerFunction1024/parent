package com.jadd;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.jadd.been.User;
import com.jadd.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testsql {


    @Autowired
    private UserMapper userMapper;

    private User user=new User();
    @Test
    public void fun01(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        User user = new User();
        user.setAge(12).setName("zs");
        ArrayList<User> users1 = Lists.newArrayList(user);
    }

    @Test
    public void fun02(){
    user.setAge(25).setName("王");
        List<User> users = userMapper.selectByCondition(user);

        users.forEach(System.out::println);


    }


    @Test
    public void fun0333(){
        System.out.println("1111111111");
        System.out.println("1111111111");

        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
    }
    @Test
    public void fun0444(){
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
    }
    @Test
    public void fun0555(){
        System.out.println("clone 测试版本回退");
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
    }
    @Test
    public void fun0666(){
        System.out.println("parent 测试版本回退提交一");
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
        System.out.println("1111111111");
    }
    @Test
    public void fun0777(){
        System.out.println("clone 测试版本回退提交一");
        System.out.println("1111111111");
    }
}
