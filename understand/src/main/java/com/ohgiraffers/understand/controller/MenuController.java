package com.ohgiraffers.understand.controller;


import com.ohgiraffers.understand.dto.MenuDTO;
import com.ohgiraffers.understand.exception.NotInsertNameException;
import com.ohgiraffers.understand.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Controller
@RequestMapping("/menus/*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("menus")
    public ModelAndView selectAllMenu(ModelAndView mv) {
        List<MenuDTO> menus = menuService.selectAllMenu();

        if (Objects.isNull(menus)){
            throw new NullPointerException();
        }
        mv.addObject("menus", menus);
        mv.setViewName("menus/allMenus");
        return mv;
    }

    @GetMapping("onemenu")
    public ModelAndView oneMenu(ModelAndView mv) {
        mv.setViewName("menus/onemenu");
        return mv;
    }

    @GetMapping("onemenuaction")
    public ModelAndView selectOneMenu(ModelAndView mv, MenuDTO menuDTO) {

        // onemenu 를 받고 onemenuaction 값을 넘김.
        MenuDTO onemenu = menuService.selectOneMenu(menuDTO);

        // 로직
        if (Objects.isNull(onemenu)){
            throw new NullPointerException();
        }

        mv.addObject("menus", onemenu);
        mv.setViewName("menus/allMenus");
        return mv;
    }

    @GetMapping("regist")
    public ModelAndView insert(ModelAndView mv) {
        mv.setViewName("menus/regist");
        return mv;
    }

    @PostMapping("regist")
    public ModelAndView insertMenu(ModelAndView mv, MenuDTO menuDTO) throws NotInsertNameException {
        int regist = menuService.regist(menuDTO);
        if (regist <= 0) {
            mv.addObject("message", "가격을 음수일 수 없도다.");
            mv.setViewName("/error/errorMessage");
        } else {
            mv.setViewName("/menus/returnMessage");
        }

        return mv;
    }
}

