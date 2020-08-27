package com.jadd.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 直接模式-消费者
 */
@Component
@RabbitListener(queues = "kudingyu")
public class Consumer_fanout2 {

    @RabbitHandler
    public void sendMessage(String msg){
        try {
            System.out.println("kudingyu接收到的消息："+msg);
        } catch (Exception e) {
            System.out.println(111);
            e.printStackTrace();
        }
    }
}