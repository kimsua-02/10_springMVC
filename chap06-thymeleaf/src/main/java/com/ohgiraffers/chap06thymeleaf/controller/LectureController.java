package com.ohgiraffers.chap06thymeleaf.controller;


import com.ohgiraffers.chap06thymeleaf.model.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lecture/*")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){

        mv.addObject("member", new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        mv.addObject("hello", "hello <h3>Thymeleaf</h3>");
        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){

        mv.addObject("num", 1);
        mv.addObject("str", "바나나");

        List<MemberDTO> membberList = new ArrayList<>();
        membberList.add(new MemberDTO("홍길동", 20, '남', "서울시 서초구"));
        membberList.add(new MemberDTO("신사임당", 34, '여', "서울시 성북구"));
        membberList.add(new MemberDTO("장보고", 45, '남', "서울시 노원구"));
        membberList.add(new MemberDTO("유관순", 17, '여', "서울시 종로구"));


        mv.addObject("memberList", membberList);

        mv.setViewName("/lecture/conditional");
        return mv;
    }
}
