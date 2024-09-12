package com.example.demo.quiz;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizQuestionForm {
	
	@NotEmpty(message="질문 제목을 입력해주세요")
	private String quizQuestionTitile; //질문 제목
	
	@NotEmpty(message="질문 내용을 입력해주세요")
	private String quizQuestionContent; //질문 내용
	
	
	

}
