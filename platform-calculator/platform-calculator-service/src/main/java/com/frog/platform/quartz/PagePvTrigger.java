package com.frog.platform.quartz;

import com.frog.platform.dao.VisitPvMapper;
import com.frog.platform.entity.VisitPv;
import com.frog.platform.entity.VisitPvExample;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PagePvTrigger {
    private static final String PAGE_PV_COUNT="PAGE_PV_COUNT";
    private static final String REDIS_HOST="192.168.2.129";
    private static final int REDIS_PORT=6379;

    @Autowired
    private VisitPvMapper visitPvMapper;

    public void pagePvStatistic(){
        JedisPool pool = new JedisPool(REDIS_HOST,REDIS_PORT);
        Jedis jedis = pool.getResource();
        Map<String, String> map = jedis.hgetAll(PAGE_PV_COUNT);
        if(map.isEmpty()){
            return;
        }

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
        jedis.close();
        pool.close();

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
