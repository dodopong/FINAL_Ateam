package com.example.demo.createQuiz;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQuizForm {
	
	@NotEmpty(message="카테고리를 선택해주세요")
	private String category;

	@NotEmpty(message="난이도를 선택해주세요")
	private Integer quizlevel;
	
	@NotEmpty(message="제목을 입력해주세요")
	@Size(max=50)
	private String quizTitle;
	
	@NotEmpty(message="문제 설명을 입력해주세요")
	private String explanation;
	
	@NotEmpty(message="제한사항을 입력해주세요")
	private String limitation;
	
	@NotEmpty(message="입출력 예룰 입력해주세요")
	private String ioEx;
	
	@NotEmpty(message="입출력 예 설명을 입력해주세요")
	private String ioExplanation;
	
	@NotEmpty(message="제시코드를 입력해주세요")
	private String presentcode;
	
	@NotEmpty(message="정답코드를 입력해주세요")
	private String solutioncode;
	
	
	private String quizFile; //추후 타입 변경 필요
	
	
	
	
	
	
}
