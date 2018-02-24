package com.frog.platform.intercept;

import com.frog.platform.utils.PagePvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageIntercept extends HandlerInterceptorAdapter {

    @Autowired
    private PagePvUtil pagePvUtil;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mv) throws Exception {

        if(mv==null){
            return ;
        }
        String viewName = mv.getViewName();
        int index = viewName.lastIndexOf("/");
        if(index==-1){
            pagePvUtil.pagePvStatistic(viewName);
        }else{
            pagePvUtil.pagePvStatistic(viewName.substring(index+1,viewName.length()));
        }


    }
}
