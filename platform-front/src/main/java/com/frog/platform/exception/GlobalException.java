package com.frog.platform.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常，用来捕获自定义异常，并处理
 */
public class GlobalException implements HandlerExceptionResolver {


    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {


        ModelAndView model = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
//        if(e instanceof ApiException){
//            Map<String, Object> map = new HashMap<String, Object>();
//            String message = ((ApiException) e).getMessage();
//            map.put("message",message);
//            map.put("status",0);
//            map.put("success",false);
//            view.setAttributesMap(map);
//            model.setView(view);
//        }else{
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("message","系统故障！"+e.getMessage());
//            map.put("status",0);
//            map.put("success",false);
//            view.setAttributesMap(map);
//            model.setView(view);
//        }
        e.printStackTrace();
        return model;
    }
}
