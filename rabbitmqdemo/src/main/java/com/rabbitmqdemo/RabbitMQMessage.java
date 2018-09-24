package com.rabbitmqdemo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessage {

    /*@RabbitListener(queues = "pqueue1.router1")
    public void listenerpe1user(User user) {
        System.out.println("RabbitMQMessage Service, listenerpe1user method, " + user);

    }*/

    @RabbitListener(queues = "pqueue1.router1")
    public void listenerpe1(Message msg) {
        System.out.println("RabbitMQMessage Service, listenerpe1 method, " + msg.getBody());
        System.out.println("RabbitMQMessage Service, listenerpe1 method, " + msg.getMessageProperties());

    }
}
