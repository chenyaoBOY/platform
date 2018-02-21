package com.frog.platform.controller;


import com.alibaba.fastjson.JSONObject;
import com.frog.platform.VisitPvService;
import com.frog.platform.entity.VisitPv;
import com.frog.platform.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    private String key1;
    private int key2;
    @Autowired
    private VisitPvService service;

    @RequestMapping("index")
    public String index(){

        VisitPv pv = service.queryByIdTest("1");
        System.out.println(pv);

        return "/index.html";
    }

    public static void main(String[] args) {
        List test = new ArrayList<>();

        String s= "["+"\"2018-02-20\""+",52"+"]";
        String s2= "["+"\"2018-02-20\","+"52"+"]";
        System.out.println(s);
        System.out.println(s2);
        test.add(s);
        test.add(s2);
        String str = JsonUtil.objectToJson(test);
        System.out.println(str);
        String s3="\"demo\"";
        System.out.println(s3);
    }
}
