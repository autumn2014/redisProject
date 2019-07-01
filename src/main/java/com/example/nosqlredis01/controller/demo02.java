package com.example.nosqlredis01.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.nosqlredis01.model.GoodsDetail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * Created by raoxiaokang on 2019/6/14.
 * 返回哈希数据对象
 */
@RestController
public class demo02 {
    public Jedis jedis;

    @RequestMapping(value = "/getHash",method = RequestMethod.GET)
    public Object getHash(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//

        String strings= jedis.hget("car","52");
        GoodsDetail goodsList= JSON.parseObject(strings,new TypeReference<GoodsDetail>(){});
        return goodsList;
    }
}
