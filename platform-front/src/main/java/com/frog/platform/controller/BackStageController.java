package com.frog.platform.controller;

import com.frog.platform.FeedbackService;
import com.frog.platform.VisitPvService;
import com.frog.platform.entity.Feedback;
import com.frog.platform.entity.VisitPv;
import com.frog.platform.utils.DateFormatUtil;
import com.frog.platform.utils.JsonUtil;
import com.frog.platform.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("back")
public class BackStageController {

    @Autowired
    private VisitPvService visitPvService;
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("manage.do")
    public String backStageManage(){


        return "/backstage/backstage_index";
    }

    @RequestMapping("getJsonData.do")
    @ResponseBody
    public String getJsonData(@RequestParam(value = "pageName",defaultValue = "business_house") String pageName){

        List<VisitPv> pvList = visitPvService.getList(pageName);
        if(pvList.isEmpty()){
            return null;
        }

        List result = new ArrayList<>();
        for (VisitPv pv : pvList) {
           Map map =new HashMap();
           map.put(DateFormatUtil.dateToString(pv.getDate()),pv.getDayVisit());
           result.add(map);
        }
        String json = JsonUtil.objectToJson(result);

        return json;
    }
    @RequestMapping("getFeedbackData.do")
    @ResponseBody
    public  List<Feedback> getFeedbackData(){

        List<Feedback> list = feedbackService.getList();
        return list;
    }
    @RequestMapping("saveFeedbackData.do")
    @ResponseBody
    public ResultUtil saveFeedbackData(Feedback feedback){
        ResultUtil result = feedbackService.saveFeedback(feedback);

        return result;
    }


}
