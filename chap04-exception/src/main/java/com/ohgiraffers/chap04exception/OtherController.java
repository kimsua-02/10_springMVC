package com.ohgiraffers.chap04exception;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @GetMapping("other-controller-null")
    public String otherNullPointerException(){
        String str = null;
        System.out.println(str.charAt(0));
        return "main";
    }

}
