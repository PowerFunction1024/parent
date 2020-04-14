package com.jadd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jadd.been.User;
import com.jadd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/method03")
    public List<User>  method03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.like("name", '雨').lt("age", 40);
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }

    @GetMapping("/method04")
    public List<User>  method04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.like("name", '雨').
                between("age", 20,40).isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }

    @GetMapping("/method05")
    public List<User>  method05(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.likeRight("name", '王').or().
                ge("age", 25).orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method06")
    public List<User>  method06(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                apply("date_format(create_time,'%Y-%m-%d')={0}","2019-02-14").
                inSql("manager_id", "select id from user where name like '王%'");
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method07")
    public List<User>  method07(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                likeRight("name","王" ).and(wq->wq.lt("age", 40).or().isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method08")
    public List<User>  method08(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                likeRight("name","王" ).
                or(wq->wq.gt("age",20 ).lt("age",40 ).isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method09")
    public List<User>  method09(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                likeRight("name","王" ).
                and(wq->wq.lt("age",40 ).or().isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method10")
    public List<User>  method10(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                in("age", Arrays.asList(30,31,34,35));
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }

    @GetMapping("/method11")
    public List<User>  method11(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                in("age", Arrays.asList(30,31,34,35)).select("id","age");
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method12")
    public List<User>  method12(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.
                in("age", Arrays.asList(30,31,34,35)).select(User.class,info->!(info.getColumn().equals("email")));
        List<User> users = userMapper.selectList(queryWrapper1);
        return  users;
    }
    @GetMapping("/method13")
    public List<User>  method13(){
        Map<String,Object> map = new HashMap();
        map.put("name","王天风" );
        map.put("age",25 );
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.allEq(map,false);
        queryWrapper.allEq((k,v)->!k.equals("name"), map);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        return  users;
    }
    @GetMapping("/method14")
    public List<Map<String, Object>>  method14(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","王" );
        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        System.out.println(users);
        users.forEach(System.out::println);
        return  users;
    }
    @GetMapping("/method15")
    public List<Map<String, Object>>  method15(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("manager_id").having("SUM(age)< {0}",500).
                select("AVG(age) avg_age,MAX(age) max_age,MIN( age) min_age");
        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        users.forEach(System.out::println);
        return  users;
    }
    @GetMapping("/method16")
    public List<User>  method16(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(User::getName,"王").lt(User::getAge, 60);
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        Integer count = userMapper.selectCount(userLambdaQueryWrapper);
        System.out.println(count);
        users.forEach(System.out::println);
        return  users;
    }
    @GetMapping("/method17")
    public List<User>  method17(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.lt(User::getAge,40 );
        //Page<User> page = new Page<>(1, 2,true);
        Page<User> page = new Page<>(1, 2,false);
        IPage<User> userIPage = userMapper.selectPage(page, userLambdaQueryWrapper);
        List<User> records = userIPage.getRecords();
        long pages = userIPage.getPages();
        long total = userIPage.getTotal();
        System.out.println(pages);
        System.out.println(total);
        records.forEach(System.out::println);
        return  records;
    }

    @GetMapping("/method18")
    public List<User>  method18(){
        User user = new User().setAge(30).setId(1087982257332887553L);
        int i = userMapper.updateById(user);
        System.out.println(i);
        return  null;
    }
    @GetMapping("/method19")
    public List<User>  method19(){
        UpdateWrapper<User> queryWrapper = new UpdateWrapper();
        queryWrapper.eq("id","1088248166370832385L");
        User user = new User().setAge(30);
        int i = userMapper.update(user,queryWrapper);
        return  null;
    }
    @GetMapping("/method20")
    public List<User>  method20(){
        User whereUser = new User().setId(1088248166370832385L);
        UpdateWrapper<User> queryWrapper = new UpdateWrapper(whereUser);
        queryWrapper.eq("id","1088248166370832385L");
        User user = new User().setAge(309);
        int i = userMapper.update(user,queryWrapper);
        return  null;
    }






}
