package com.example.demo.intercept;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/* 클래스 설명
로그인하지 않았을 때 접근할 수 없는 페이지 처리 (인터셉터)
preHandle : 요청을 처리하기 이전에 가로채서 처리
언제 동작하는지 지정하기 위해 servlet-context.xml에서 어느 인터셉터가 어떤 매핑일 때 동작하는 지 명시
*/
@Component //bean(객체)으로 등록하기 위해 사용
public class RequiredLoginInterceptor implements HandlerInterceptor {

	@Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    
	    HttpSession session = request.getSession();
	    										//유저가 맞나?
	    if(session != null && session.getAttribute("user") == null) { //로그인하지 않았을 때
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<script>");
	      out.println("if(confirm('로그인이 필요한 기능입니다. 로그인할까요?')){");
	      out.println("location.href='" + request.getContextPath() + "/user/login.form'");
	      out.println("} else {");
	      out.println("history.back()");
	      out.println("}");
	      out.println("</script>");
	      out.flush();
	      out.close();
	      
	      return false;  // 가로챈 컨트롤러 요청이 동작하지 않는다
	      
	    }
	    
	    return true;     // 가로챈 컨트롤러 요청이 동작한다
	    
	  }
	
}
