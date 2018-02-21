package com.frog.platform.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        StringBuffer url = request.getRequestURL();
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String method = request.getMethod();


        System.out.println("url:"+url);
        System.out.println("remoteAddr:"+remoteAddr);
        System.out.println("remoteHost:"+remoteHost);
        System.out.println("method："+method);

        chain.doFilter(request, response);

        System.out.println("11111");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
