package com.jadd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jadd.been.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectByCondition(@Param("user") User user);
}
