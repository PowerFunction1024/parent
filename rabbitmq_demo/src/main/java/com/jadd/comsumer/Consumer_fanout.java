package com.jadd.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 直接模式-消费者
 */
@Component
@RabbitListener(queues = "itheima ")
public class Consumer_fanout {

    @RabbitHandler
    public void sendMessage(String msg){
        try {
            System.out.println("itheima接收到的消息："+msg);
        } catch (Exception e) {
            System.out.println(111);
            e.printStackTrace();
        }
    }
}