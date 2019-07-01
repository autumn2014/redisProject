package com.example.nosqlredis01.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig extends CachingConfigurerSupport {
    private Logger logger=LoggerFactory.getLogger(JedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${my.name}")
    private String name;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        return jedisPool;
    }
}
