package com.example.nosqlredis01.common;

import com.example.nosqlredis01.model.Goods;
import com.example.nosqlredis01.model.GoodsLog;
import com.example.nosqlredis01.util.Json;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Date;

public class RedisTestGoodsLog {
    public Jedis jedis;
    @Test
    public void test(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//
        //
        jedis.flushDB();
        Pipeline pipeline=jedis.pipelined();
        pipeline.sadd("goods-log",this.initGoodsLog());
        pipeline.expire("goods-log",50*60);
        System.out.println(pipeline.syncAndReturnAll());
    }

    private String[] initGoodsLog(){
        String[] goodsArray=new String[5];
        for(int i=0;i<5;i++) {
            GoodsLog goodsLog = new GoodsLog();
            goodsLog.setId(i);
            goodsLog.setClickDate(new Date());
            goodsLog.setIp("12.3.2.1");
            goodsLog.setUuid("001");
            goodsArray[i]=Json.toJson(goodsLog);
        }

        return goodsArray;
    }
}
