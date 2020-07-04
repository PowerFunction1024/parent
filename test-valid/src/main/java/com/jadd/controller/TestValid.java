package com.jadd.controller;

import com.jadd.been.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User().setName("ab"),
                new User().setName("cd"),
                new User().setName("cd"),
                new User().setName("cs"),
                new User().setName("kk"));
        ArrayList<User> dto = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new));
        System.out.println(dto);

        Set<String> all = new TreeSet<String>() ;
        all.add("D") ;
        all.add("A") ;  // 内容重复了
        all.add("B") ;
        all.add("B") ;
        all.add("C") ;
        System.out.println(all);
        System.out.println("----------------------");

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        Stream<String[]> stream = words.stream().map(e -> e.split(""));

        List<Stream<String>> collect1 = stream.map(e -> Arrays.stream(e)).collect(Collectors.toList());

        //flatMap主要作用是把map(e -> Arrays.stream(e))时生成的每个流合并起来,即扁平化为一个流
        List<String> collect = stream.flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());

    }

}
