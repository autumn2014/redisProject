package com.example.nosqlredis01.common;

import com.example.nosqlredis01.model.Goods;
import com.example.nosqlredis01.model.GoodsDetail;
import com.example.nosqlredis01.util.Json;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class RedisTestGoodsDetail {
    public Jedis jedis;
    @Test
    public void test(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//
        //
//        jedis.flushDB();//

        Pipeline pipeline=jedis.pipelined();
        pipeline.hmset("car",this.initGoodsDetail());
        pipeline.expire("car",50*60);
        long t1=System.currentTimeMillis();
        System.out.println(pipeline.syncAndReturnAll());
        long t2=System.currentTimeMillis();
        System.out.printf("管道添加数据时间:%d毫秒",t2-t1);
    }

    private Map<String,String> initGoodsDetail(){
        Map<String,String> map=new HashMap<String,String>();
        GoodsDetail goodsDetail=new GoodsDetail();
        goodsDetail.setGoodsInfo("《京东平台数据化运营》");
        goodsDetail.setId(40);
        goodsDetail.setPrice("48.5");
        goodsDetail.setAmount("8");
        map.put(goodsDetail.getId()+"",Json.toJson(goodsDetail));

        for(int i=500000;i<1000000;i++) {
            goodsDetail.setGoodsInfo("《000000000》");
            goodsDetail.setId(i);
            goodsDetail.setPrice(String.valueOf(Math.random()));
            goodsDetail.setAmount("15");
            map.put(goodsDetail.getId() + "", Json.toJson(goodsDetail));
        }
        return map;
    }
}
