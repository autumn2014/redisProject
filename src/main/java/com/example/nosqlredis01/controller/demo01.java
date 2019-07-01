package com.example.nosqlredis01.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.nosqlredis01.model.Goods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回List
 */
@RestController
public class demo01 {
    public Jedis jedis;

    @RequestMapping(value ="/get")
    public Object get(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//
//        return jedis.lrange("goods-recommend",0,5);
        List<JSONObject> list=new ArrayList<>();
        List<String> strings=jedis.lrange("goods-recommend",0,2);
//        for(int i=0;i<strings.size();i++){
//            list.add(JSONObject.parseObject(strings.get(i)));
//        }
//        return list;


        List<Goods> goodsList= JSON.parseObject(strings.toString(),new TypeReference<List<Goods>>(){});
        return goodsList;
}

}
