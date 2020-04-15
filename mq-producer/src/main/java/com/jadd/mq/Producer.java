package com.jadd.mq;

import com.jadd.channel.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class Producer {
    //@Autowired
    //@Output(Source.OUTPUT)
    //private MessageChannel channel;

    @Resource
    private Source channel;

    public void send() {
        //channel.send(MessageBuilder.withPayload("22222222222" + UUID.randomUUID().toString()).build());
        channel.output().send(MessageBuilder.withPayload("22222222222" + UUID.randomUUID().toString()).build());
    }

}
