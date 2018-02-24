package com.frog.platform.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class PagePvUtil {

    @Autowired
    private  JedisPool jedisPool;
    private static final String PAGE_PV_COUNT="PAGE_PV_COUNT";
//    private static final String REDIS_HOST="192.168.2.129";
//    private static final int REDIS_PORT=6379;


    public  void pagePvStatistic(String pageName){
//        JedisPool pool = new JedisPool(REDIS_HOST,REDIS_PORT);
        Jedis jedis = jedisPool.getResource();
        String num = jedis.hget(PAGE_PV_COUNT, pageName);
        if(num==null){
            jedis.hset(PAGE_PV_COUNT, pageName,"1");
        }else{
            Long count = Long.valueOf(num);
            jedis.hset(PAGE_PV_COUNT, pageName,++count+"");
        }
        jedis.close();
//        pool.close();
    }



}
