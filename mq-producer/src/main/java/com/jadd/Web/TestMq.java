package com.jadd.Web;

import com.jadd.mq.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2020/4/14
 */
@RestController
@RequestMapping("/testmq")
public class TestMq {

    @Resource
    private Producer producer;
    @GetMapping("/send")
    public void send(){
        producer.send();
    }

}
