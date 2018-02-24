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


    public  void pagePvStatistic(String pageName){
        Jedis jedis = jedisPool.getResource();
        try{
            String num = jedis.hget(PAGE_PV_COUNT, pageName);
            if(num==null){
                jedis.hset(PAGE_PV_COUNT, pageName,"1");
            }else{
                Long count = Long.valueOf(num);
                jedis.hset(PAGE_PV_COUNT, pageName,++count+"");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }



}
