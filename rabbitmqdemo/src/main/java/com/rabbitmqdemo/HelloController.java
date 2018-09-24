package com.rabbitmqdemo;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/rabbitmq")
public class HelloController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitMQMessage rabbitMQMessage;

    @GetMapping("/pe1send")
    public String send() {
        System.out.println("send");
        rabbitTemplate.convertAndSend("pexchange1", "pqueue1.router1", "helllllo");
        return "success";
    }

    @PostMapping("/pe1send/user")
    public String sendUser(@RequestBody User user) {
        System.out.println("send");
        rabbitTemplate.convertAndSend("pexchange1", "pqueue1.router1", user);
        return "success";
    }

    @GetMapping("/pe1get")
    public Object get() {
        System.out.println("get");
        Object msg = rabbitTemplate.receiveAndConvert("pqueue1.router1");
        //System.out.println(msg.getClass().getName());
        System.out.println(msg);
        return msg;
    }

//    @GetMapping("/pe1get/user")
//    public Object getUser() {
//        System.out.println("getUser");
//        //Object msg = rabbitTemplate.receiveAndConvert("pqueue1.router1");
//        //System.out.println(msg.getClass().getName());
//        Object msg = rabbitMQMessage.
//        System.out.println(msg);
//        return msg;
//    }

    @PostMapping("/exchange/{name}")
    public String postexchange(@PathVariable String name) {
        System.out.println("add exchange to rabbitmq");
        amqpAdmin.declareExchange(new DirectExchange("hello", true, false));
        return "success";
    }

    @PostMapping("/queue/{name}")
    public String postqueue(@PathVariable String name) {
        System.out.println("add queue to rabbitmq");
        amqpAdmin.declareQueue(new Queue("world",true));
        return "success";
    }

    @PostMapping("/binding/{name}")
    public String postbinding(@PathVariable String name) {
        System.out.println("add queue to rabbitmq");
        amqpAdmin.declareBinding(new Binding("world", Binding.DestinationType.QUEUE,"hello","helloworld",null));
        return "success";
    }
}
