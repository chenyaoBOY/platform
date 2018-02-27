package com.frog.platform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @RequestMapping("register.do")
    public String register(){


        return "global/register";
    }

}
