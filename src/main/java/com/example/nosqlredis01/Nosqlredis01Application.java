package com.example.nosqlredis01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Nosqlredis01Application {
    @Value("${my.name}")
    private String name;

    @RequestMapping(value = "/")
    String home(){
        return "hello:"+name;
    }
    public static void main(String[] args) {
        SpringApplication.run(Nosqlredis01Application.class, args);
    }

}
