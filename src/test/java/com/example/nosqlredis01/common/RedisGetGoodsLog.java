package com.example.nosqlredis01.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.nosqlredis01.model.Goods;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * 获取缓存李彪列表数据
 */
public class RedisGetGoodsLog {
    public Jedis jedis;
    @Test
    public void test(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//
        System.out.println(jedis.smembers("goods-log"));

//        List<String> strings=jedis.lrange("goods-recommend",0,2);
//        List<Goods> goodsList=JSON.parseObject(strings.toString(),new TypeReference<List<Goods>>(){});
//        System.out.println(goodsList);
//        for(int i=0;i<3;i++){
//            System.out.println(JSONObject.parseObject(strings.get(i)));
//        }



        String s="{\"name\":\"张三\",\"id\":\"1\"}";
        JSONObject j1=JSONObject.parseObject(s);

        System.out.println(j1);
    }

    @Test
    public void get(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//

    }

}
