package com.frog.platform.quartz;

import com.frog.platform.dao.VisitPvMapper;
import com.frog.platform.entity.VisitPv;
import com.frog.platform.entity.VisitPvExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PagePvTrigger {
    @Autowired
    private JedisPool jedisPool;
    private static final String PAGE_PV_COUNT="PAGE_PV_COUNT";
    private static final Logger logger = LoggerFactory.getLogger(PagePvTrigger.class);

    @Autowired
    private VisitPvMapper visitPvMapper;

    /**
     * 每5分钟刷新一次访问数据  将redis中的数据存储到数据库
     */
    public void pagePvStatistic(){
        logger.info("开始刷新访问数据-----------------");
        Jedis jedis = jedisPool.getResource();
        try{
            Map<String, String> map = jedis.hgetAll(PAGE_PV_COUNT);
            Date date = formateDate(new Date());

            for (String key : map.keySet()) {
                VisitPvExample example = new VisitPvExample();
                VisitPvExample.Criteria criteria = example.createCriteria();
                criteria.andPageNameEqualTo(key);
                criteria.andDateEqualTo(date);

                List<VisitPv> list = visitPvMapper.selectByExample(example);

                VisitPv pv = new VisitPv();
                pv.setId(UUID.randomUUID().toString());
                pv.setDate(date);
                pv.setPageName(key);
                pv.setDayVisit(Long.valueOf(map.get(key)));

                if(list.isEmpty()){
                    visitPvMapper.insert(pv);
                }else{
                    VisitPv pv1 = list.get(0);
                    pv1.setDayVisit(Long.valueOf(map.get(key)));
                    visitPvMapper.updateByPrimaryKey(pv1);
                }
            }
        }catch (Exception e){
            logger.info(e.getStackTrace().toString());
        } finally {
            jedis.close();
        }

        logger.info("结束刷新-----------------");
    }

    public Date formateDate(Date date){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        Date date2 = null;
        try{
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

            date2 = format2.parse(str);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date2;
    }



}
