package com.jadd.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jadd.been.User;
import com.jadd.mapper.UserMapper;
import com.jadd.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/4/5
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public User test01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1087982257332887553L);
        List<User> users = baseMapper.selectList(queryWrapper);
        Map<String, Object> map = getMap(queryWrapper);
        System.out.println(map);
        users.forEach(System.out::println);
        return null;
    }

    @Override
    public List<User> test02() {
        User user = new User().setAge(30);
        List<User> users = baseMapper.selectByCondition(user);
        users.forEach(System.out::println);
        return null;
    }
}
