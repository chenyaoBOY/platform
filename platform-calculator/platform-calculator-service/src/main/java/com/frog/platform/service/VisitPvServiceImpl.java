package com.frog.platform.service;

import com.frog.platform.dao.VisitPvMapper;
import com.frog.platform.entity.VisitPv;
import com.frog.platform.VisitPvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitPvServiceImpl implements VisitPvService {

    @Autowired
    private VisitPvMapper mapper;
    @Override
    public VisitPv queryByIdTest(String id) {

        VisitPv pv = mapper.selectByPrimaryKey("1");

        return pv;
    }
}
