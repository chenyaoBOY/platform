package com.frog.platform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @RequestMapping("register.do")
    public String register(ModelMap map){

//        map.put("backgroundUrl","/images/Europe.jpg");//日后拓展


        return "global/register";
    }
    @RequestMapping("login.do")
    public String login(ModelMap map){

//        map.put("backgroundUrl","/images/Europe.jpg");//日后拓展


        return "global/login";
    }

}
