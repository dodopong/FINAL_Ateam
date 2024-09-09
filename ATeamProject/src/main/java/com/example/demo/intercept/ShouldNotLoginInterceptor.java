package com.example.demo.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
/* 클래스 설명
ShouldNotLoginInterceptor : 
	 로그인이 되어있을 때 로그인 안되어 있는 상태에서 수행해야 할 페이지에 들어가는 것도 막아준다 
	 (로그인이 되어 있으면 가입이나, 로그인이나, 약관동의 페이지에 들어가지 못함)
로그인하지 않았을 때 접근할 수 없는 페이지 처리 (인터셉터)
preHandle : 요청을 처리하기 이전에 가로채서 처리
언제 동작하는지 지정하기 위해 servlet-context.xml에서 어느 인터셉터가 어떤 매핑일 때 동작하는 지 명시
*/
@Component //bean(객체)으로 등록하기 위해 사용
public class ShouldNotLoginInterceptor implements HandlerInterceptor {

}
