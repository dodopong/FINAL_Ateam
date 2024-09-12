package com.example.demo.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class QuizStudent { //맴버의 정보 필요

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizStudentKey;
	
	private String submitCode; //(수강생)제출코드
	
	@ManyToOne 
    private Quiz quiz; 
	
	private Integer challenge; //도전한 문제 수(제출코드의 수)
	
	private Integer guess; //맞춘 문제 수
	
	private Integer run; //(수강생)총 실행 횟수
	
//	@ManyToOne
//	private Member author; //Member정보를 가져오기 위함
	
	
//  private String delYn; 현업에서는 관리자 삭제권한 필요
}
