package com.frog.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrogCalcultorController {


    @RequestMapping("/")
    public String indexPage(ModelMap map){
//        map.put("guideStatus",0);
        return "redirect:tax.do";
    }

    @RequestMapping("/tax.do")
    public String tax(ModelMap map, @RequestParam(value = "type",defaultValue = "0") Integer type){
        map.put("guideStatus",1);
        if(type == 0){//商品房
            map.put("pageStatus",0);
            return "calculator/business_house";
        }else if(type == 1){//一类经适房
            map.put("pageStatus",1);
            return "calculator/one_house";
        }else if(type == 2){//二类经适房
            map.put("pageStatus",2);
            return "calculator/two_house";
        }else if(type == 3){//央产房
            map.put("pageStatus",3);
            return "calculator/central_house";
        }else if(type == 4){//商住两用房
            map.put("pageStatus",4);
            return "calculator/business_live_house";
        }else{
            return "global/error_page";
        }
    }
    @RequestMapping("businessLoan.do")
    public String businessLoan(ModelMap map){
        map.put("guideStatus",1);
        map.put("pageStatus",5);

        return "calculator/business_loan";
    }
    @RequestMapping("foundLoan.do")
    public String foundLoan(ModelMap map){
        map.put("guideStatus",1);
        map.put("pageStatus",6);

        return "calculator/found_loan";
    }

}
