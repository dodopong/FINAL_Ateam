package com.example.demo.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuizController {

	private final QuizService qs;
	
	@GetMapping(value = "/quiz") //퀴즈풀기 페이지(학생)
	public String quiz(QuizForm quizForm) {
		return "quiz";
	}
	
	//예외처리 로그인 하지 않은 유저가 퀴즈페이지를 접속했을때
	
	
	
	
}
