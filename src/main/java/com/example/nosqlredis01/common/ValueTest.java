package com.example.nosqlredis01.common;

import org.springframework.beans.factory.annotation.Value;

public class ValueTest {
    @Value("${my.name}")
    private String name;

    public ValueTest(){
        System.out.println(name);
    }
    public void F(){

    }
}
