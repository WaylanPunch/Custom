package com.way.buytickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient//开启发现服务功能
@SpringBootApplication
public class BuyticketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyticketsApplication.class, args);
    }

    @LoadBalanced//使用负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
