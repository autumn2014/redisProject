package com.example.nosqlredis01.common;

import com.example.nosqlredis01.model.Goods;
import com.example.nosqlredis01.util.Json;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import static org.junit.Assert.*;

public class RedisTestGoods {
    public Jedis jedis;
    @Test
    public void test(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//
        //
        Pipeline pipeline=jedis.pipelined();
        pipeline.lpush("goods-recommend",this.initGoods());
        pipeline.expire("goods-recommend",50*60);
        System.out.println(pipeline.syncAndReturnAll());
    }

    private String[] initGoods(){
        Goods goods=new Goods();
        goods.setAdInfo("<html></html>");
        goods.setGoodsInfo("商品嘻嘻你:苹果笔记本");
        goods.setSpecificationsInfo("美国加利福利亚州生产");
        String[] goodsArray=new String[10];
        for(int i=0;i<10;i++){
            goodsArray[i]=Json.toJson(goods);
        }
        return goodsArray;
    }
}
