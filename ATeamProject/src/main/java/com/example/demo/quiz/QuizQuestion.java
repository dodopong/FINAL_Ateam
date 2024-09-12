package com.example.demo.quiz;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class QuizQuestion { //퀴즈의 질문관련 엔티티(수강생)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false) //?
	private Integer quizQuestionKey;
	
	private String quizQuestionTitle; //질문 제목
	
	private String quizQuestionContent; //질문 내용
	
	private LocalDateTime qDate; //질문 날짜관리(작성,수정일자)

	//@OneToMany 
	//하나의 quiz에 여러개의 질문
	//private List<QuizQuestion> quizQuestion; 수정필요
	//(수강생)질문
	
	
//	@ManyToOne
//	private Member author; //Member정보를 가져오기 위함

}
