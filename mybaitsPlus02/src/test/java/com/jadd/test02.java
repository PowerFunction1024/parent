package com.jadd;

import com.google.common.collect.Lists;
import com.jadd.been.User;
import com.jadd.been.User02;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

public class test02 {
    @Test
    public void fun01(){
        User u = new User().setName("zs").setAge(78).setId(45L);
        User02 user02 = new User02();
        BeanUtils.copyProperties(u,user02 );
        System.out.println(user02);
    }

    @Test
    public void fun02(){
        String json="";
        User u1 = new User().setName("zs").setAge(78).setId(45L);
        User u2 = new User().setName("zs").setAge(78).setId(45L);
        User u3 = new User().setName("zs").setAge(78).setId(45L);
        ArrayList<User> users = Lists.newArrayList(u1, u2, u3);
        ArrayList<User02> al = new ArrayList();
        BeanUtils.copyProperties(users,al);
        System.out.println(al);
    }

    @Test
    public void fun03(){
        User u1 = new User().setName("zs").setAge(78).setId(45L);
        User u2 = new User().setName("zs").setAge(78).setId(45L);
        User u3 = new User().setName("zs").setAge(78).setId(45L);
        ArrayList<User> users = Lists.newArrayList(u1, u2, u3);
        ArrayList<User02> al = new ArrayList();
        BeanUtils.copyProperties(users,al);
        System.out.println(al);
    }

}
