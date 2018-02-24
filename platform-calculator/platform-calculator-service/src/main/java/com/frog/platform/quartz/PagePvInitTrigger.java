package com.frog.platform.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PagePvInitTrigger {

    @Autowired
    private JedisPool jedisPool;
    private static final String PAGE_PV_COUNT="PAGE_PV_COUNT";
//    private static final String REDIS_HOST="192.168.2.129";
//    private static final int REDIS_PORT=6379;
    public void initPagePv(){

//        JedisPool pool = new JedisPool(REDIS_HOST,REDIS_PORT);
        Jedis jedis = jedisPool.getResource();
        Long hdel = jedis.del(PAGE_PV_COUNT);

        jedis.close();
//        pool.close();
    }
}
