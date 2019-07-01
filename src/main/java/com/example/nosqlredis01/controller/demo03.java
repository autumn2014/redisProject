package com.example.nosqlredis01.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.nosqlredis01.model.GoodsDetail;
import com.example.nosqlredis01.model.GoodsLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * Created by raoxiaokang on 2019/6/14.
 * 返回集合数据对象
 */
@RestController
public class demo03 {
    public Jedis jedis;

    @RequestMapping(value = "/getSet",method = RequestMethod.GET)
    public Object getSet(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//

        Set<String> strings= jedis.smembers("goods-log");
//        return strings;
        List<GoodsLog> goodsList= JSON.parseObject(strings.toString(),new TypeReference<List<GoodsLog>>(){});
        return goodsList;
    }
}
