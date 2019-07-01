package com.example.nosqlredis01.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Set;
import java.io.IOException;

import static org.junit.Assert.*;

public class ValueTestTest {

    public Jedis jedis;
    @Before
    public void initJedis() throws IOException{
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379,2000,null);

        jedis=jedisPool.getResource();//
    }
    @Test
    public void f() {
        jedis.flushDB();

        long t1=System.currentTimeMillis();
        noPipeline(jedis);
        long t2=System.currentTimeMillis();
        System.out.printf("非管道方式用时：%d毫秒",t2-t1);

//        jedis.flushDB();
         t1=System.currentTimeMillis();
        Pipeline(jedis);
         t2=System.currentTimeMillis();
        System.out.printf("管道方式用时：%d毫秒",t2-t1);
    }
    public void noPipeline(Jedis jedis){
        try{
            for(int i=0;i<10000;i++)
                jedis.sadd("SetAdd",String.valueOf(i) );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Pipeline(Jedis jedis){
        try{
            Pipeline p1=jedis.pipelined();
            for(int i=0;i<10000;i++)
                p1.sadd("SAdd",String.valueOf(i*10) );
            p1.sync();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void closeJedis(){
        jedis.close();
    }
}