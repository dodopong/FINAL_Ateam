package com.example.demo.createQuiz;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreateQuiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer createQuizKey;

	private String category; //카테고리 선택
	
	private Integer quizlevel; //퀴즈 난이도 1~5
	
	@Column(unique = true)
	private String quizTitle; //문제 제목
	
	private String explanation; //문제 설명
	
	private String limitation; //제한사항
	
	private String ioEx; //입출력 예
	
	private String ioExplanation; //입출력 예 설명
	
	private String presentcode; //제시코드
	
	private String solutioncode; //정답코드
	
	private String quizFile; //문제 참고파일(강사가 업로드하는 파일)
							 //추후 타입 변경 필요
//	@ManyToOne
//	private Member author; //Member정보를 가져오기 위함

}
