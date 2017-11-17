package com.fx.la.common;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class SendAndReceive {
    private static ExecutorService service = Executors.newFixedThreadPool(2);
    @Autowired
    private static RabbitTemplate rabbitTemplate;

    public static void send(String msg){
        rabbitTemplate.convertAndSend("topicExchange","topic.one",msg);
    }
    public static void receive(String msg){

    }
}
