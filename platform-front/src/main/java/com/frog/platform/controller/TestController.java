package com.frog.platform.controller;


import com.frog.platform.VisitPvService;
import com.frog.platform.entity.VisitPv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private VisitPvService service;

    @RequestMapping("index")
    public String index(){

        VisitPv pv = service.queryByIdTest("1");
        System.out.println(pv);

        return "/index.html";
    }
}
