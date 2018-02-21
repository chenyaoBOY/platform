package com.frog.platform.service;

import com.frog.platform.dao.VisitPvMapper;
import com.frog.platform.entity.VisitPv;
import com.frog.platform.VisitPvService;
import com.frog.platform.entity.VisitPvExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitPvServiceImpl implements VisitPvService {

    @Autowired
    private VisitPvMapper mapper;
    @Override
    public VisitPv queryByIdTest(String id) {

        VisitPv pv = mapper.selectByPrimaryKey("1");

        return pv;
    }

    @Override
    public List<VisitPv> getList(String pageName) {
        VisitPvExample ex = new VisitPvExample();
        ex.setOrderByClause("date");
        ex.createCriteria().andPageNameEqualTo(pageName);
        List<VisitPv> list = mapper.selectByExample(ex);
        return list;
    }
}
