package com.example.nosqlredis01.common;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

public class RedisUtil {
    public RedisUtil(){

    }
    public static JedisPool initPool() throws IOException{
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        return jedisPool;
    }
}
