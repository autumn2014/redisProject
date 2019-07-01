package com.example.nosqlredis01.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class JedisConfigTest {

    @Test
    public void test() {
        JedisConfig jedisConfig=new JedisConfig();
        jedisConfig.redisPoolFactory();
    }

    @Test
    public void test01(){
        ValueTest valueTest=new ValueTest();
    }
}