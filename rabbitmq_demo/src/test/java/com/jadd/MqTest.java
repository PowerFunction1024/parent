package com.jadd;

import com.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class MqTest {

    @Autowired
    private RabbitMessagingTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","我要红包");
    }
    @Test
    public void testSend_fanout(){
        rabbitTemplate.convertAndSend("chuanzhi ","","fanout");

    }

}