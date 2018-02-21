package com.frog.platform;


import com.frog.platform.entity.VisitPv;

import java.util.List;

public interface VisitPvService {


    VisitPv queryByIdTest(String id);

    /**
     * 根据页面名称获取页面访问量数据
     * @param pageName
     * @return
     */
    List<VisitPv> getList(String pageName);
}
