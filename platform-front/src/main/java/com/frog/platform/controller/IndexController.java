package com.frog.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站首页
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexPage(ModelMap map){
        map.put("guideStatus",1);
        return "response_web/index";
    }
    @RequestMapping("/test.do")
    public String test(ModelMap map){
        map.put("guideStatus",1);
        return "response_web/test";
    }
}
