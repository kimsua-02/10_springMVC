package com.ohgiraffers.understand.exception;

// 중복된 이름 발견시 날릴 용도
// 기존 메뉴에 중복된 이름이 있을 시 발생ㅅ시킬 인셉션
public class NotInsertNameException extends Exception{

    public NotInsertNameException(String message) {
        super(message);
    }


}
