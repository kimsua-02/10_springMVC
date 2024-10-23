package com.ohgiraffers.chap02handlermethod;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class FirstController {

    @GetMapping("regist")  // 요청이 중요함. 디렉토리 설계 시 잘 정해야 함.
    public void regist(){} // 'regist' 같은 명은 중요하지 X

    @PostMapping("regist")
    public String regist(Model model, WebRequest request){
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록 하셨습니다.";
        System.out.println(message);
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void vodify(){}


    // required = 파라미터 포함 여부 , name = 이름 , defaultaValue = 기본 값
//    @PostMapping("modify")
//    public String modify(Model model,
//                         @RequestParam(required = false, name = "modifyName") String modifyName,
//                         @RequestParam(defaultValue = "0", name = "modifyPrice") int modifyPrice){
//        String message = modifyName + " 메뉴 가격을 " + modifyPrice + "원으로 변경하였습니다.";
//        System.out.println(message);
//        model.addAttribute("message", message);
//        return "first/messagePrinter";
//    }

    @PostMapping("modify")
    public String modify(Model model, @RequestParam Map<String, String> parameters){
        String modifyName = parameters.get("modifyName");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice"));

        String message = modifyName + " 메뉴 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        System.out.println(message);
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search(){}

    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu){
        System.out.println(menu);
        return "first/searchResult";
    }

    // 4. sesssion 이용하기
    @GetMapping("login")
    public void login(){}

    // 4-1 : HttpSession 을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 호출함.
    @PostMapping("login")
    public String sessionTest1(HttpSession session, @RequestParam String id){
        session.setAttribute("id", id);
        return "first/loginResult";
    }

    // 세션에 담금. 아무튼 단순한 로직임.
    @GetMapping("logout1")
    public String logout1(HttpSession session){
        session.invalidate();
        return "first/login";
    }

    /*
    * 4-2. SessionAttribute 를 이용하여 session에 값 담기
    * 클래스 레벨에 @SessionAttribute 어노테이션을 이용하여 세션에 값을 담을 key 를 설정해두면,
    * model 영역에 해당 key 로 값이 추가되는 겨우우 Session 에 자동 등록한다.
    * (@SessionAttribute 로 지정된 속성은 해당 컨드롤러 내에서만 유효하다.)
    * */


    @PostMapping("login2")
    public String sesstionTest2(Model model, @RequestParam String id){
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    // SessionAttribute 로 등록된 값은 session의 상태를 관리하는 sessionStatus 의 setComplete() 메소드를 호출해야 사용이 만료된다.

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("body")
    public void body(){}


    /*
    * 5. @RequestBody 를 이용하는 방법
    * 해당 어노테이션은 http 본문 자체를 읽는 부분을 모델로 변환시켜주는 어노테이션이다.
    * */

    @PostMapping("body")
    public void bodyTest(@RequestBody String body) throws UnsupportedEncodingException {
        System.out.println(body);
        System.out.println(URLDecoder.decode(body,"UTF-8"));
    }

}
