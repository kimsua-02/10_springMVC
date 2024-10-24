package com.ohgiraffers.chap04exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Exception 이 발생했을 때 핸들링 해주는 클래스를 만드는 어노테이션
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPinterExceptionHandler(NullPointerException e) {
        System.out.println("Global(서버에서 발생하는 모든) 레벨의 Exception 처리");
        return "error/nullPointer";
    }

}
