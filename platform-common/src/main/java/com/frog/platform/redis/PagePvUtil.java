package com.frog.platform.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class PagePvUtil {


    private static final String PAGE_PV_COUNT="PAGE_PV_COUNT";
    private static final String REDIS_HOST="192.168.2.129";
    private static final int REDIS_PORT=6379;


    public static void pagePvStatistic(String pageName){
        JedisPool pool = new JedisPool(REDIS_HOST,REDIS_PORT);
        Jedis jedis = pool.getResource();
        String num = jedis.hget(PAGE_PV_COUNT, pageName);
        if(num==null){
            jedis.hset(PAGE_PV_COUNT, pageName,"1");
        }else{
            Long count = Long.valueOf(num);
            jedis.hset(PAGE_PV_COUNT, pageName,++count+"");
        }
        jedis.close();
        pool.close();
    }



    public static void main(String[] args) {
        pagePvStatistic("house_business");
    }
}
