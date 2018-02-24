package com.frog.platform.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PagePvInitTrigger {

    @Autowired
    private JedisPool jedisPool;
    private static final Logger logger = LoggerFactory.getLogger(PagePvInitTrigger.class);
    private static final String PAGE_PV_COUNT="PAGE_PV_COUNT";


    /**
     * 每日凌晨  初始化访问量数据
     */
    public void initPagePv(){

        logger.info("开始初始化访问数据------------");

        Jedis jedis = jedisPool.getResource();
        try{
            jedis.del(PAGE_PV_COUNT);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        logger.info("结束初始化访问数据------------");
    }
}
