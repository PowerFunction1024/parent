package com.jadd.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 直接模式-消费者
 */
@Component
@RabbitListener(queues = "itcast")
public class Consumer1 {

    @RabbitHandler
    public void sendMessage(String msg){
        try {
            System.out.println("接收到的消息："+msg);
        } catch (Exception e) {
            System.out.println(111);
            e.printStackTrace();
        }
    }
}