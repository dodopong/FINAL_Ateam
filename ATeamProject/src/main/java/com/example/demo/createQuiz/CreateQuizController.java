package com.example.demo.createQuiz;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CreateQuizController {
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/createquiz") //퀴즈만들기 페이지(강사)
	public String createquiz(CreateQuizForm createQuiz) {
		return "createquiz";
	}
	
	

}
