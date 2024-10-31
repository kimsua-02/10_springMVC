package com.ohgiraffers.chap08securitysession.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @GetMapping
    public String root(){
        return "index";
    }

    @GetMapping("/admin/page")
    public ModelAndView admin(ModelAndView mv){
        mv.setViewName("admin/admin");
        return mv;
    }

    @GetMapping("user/page")
    public ModelAndView user(ModelAndView mv){
        mv.setViewName("user/user");
        return mv;
    }
}
