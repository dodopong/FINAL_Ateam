package com.example.demo.quiz;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuizController {

	private final QuizService qs;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/quiz") //퀴즈풀기 페이지(수강생)
	public String quiz(QuizForm quizForm) {
		return "quiz";  
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/createquiz") //퀴즈만들기 페이지(강사)
	public String createquiz(CreateQuizForm createQuiz) {
		return "createquiz";
	}
	
	
}
