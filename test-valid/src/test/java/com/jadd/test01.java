package com.jadd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/3/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class test01 {

    @Value("${aa.bb}")
    private String bb;

    @Test
    public void fun01(){
        System.out.println(
                bb
        );


    }


}
