package com.jadd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jadd.been.User;

import java.util.List;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/4/5
 */
public interface UserService extends IService<User>{

     User test01_1();

     List<User> test02();
}
