package com.example.swagger2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Swagger2demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Swagger2demoApplication.class, args);
    }
}
