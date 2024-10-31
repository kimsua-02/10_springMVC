package com.ohgiraffers.chap08securitysession.config.handler;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;

// 요청 실패 커스텀 핸들러

@Configuration
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {


    // 실패 시 행동을 정할 메소드
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = null;

        if (exception instanceof BadCredentialsException) {
            // 사용자의 아이디가 DB 에 존재하지 않는 경우 or 비밀번호가 맞지 않는 경우
            errorMessage = "비밀번호가 존재하지 않거나 비밀번호가 일치하지 않습니다.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            // 서버에서 사용자 정보를 검증하는 과정에서 발생하는 에러 -- 대부분 잘못된 코드
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            // 인증번호가ㅣ 없는 상태에서 보안처리된 리소스에 접근하는 경우
            errorMessage = "인증 요청이 거부되었습니다.";
        } else {
            errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다.";
        }
        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
        // 요청이 실패했을 시 보낼 곳 지정 - 인코딩 후
        setDefaultFailureUrl("auth/fail?message=" + errorMessage);

        // 수행 부분만 정의하고 나머지는 super 애게 보내서 처리
        super.onAuthenticationFailure(request, response, exception);
    }
}
