package com.example.demo.quiz;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class QuizAnswer { //퀴즈 질문에 대한 답변 관련 엔티티(강사)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizAnswerKey;	
	
	//mappedBy => 설정되지 않은 쪽이 주인(테이블 관리 가능) , 설정된 쪽은 조회만 가능									
	//@OneToOne //(mappedBy = "question", cascade = CascadeType.REMOVE)
	//private List<QuizAnswer> quizAnswerList;	
	
	private LocalDateTime aDate; //답변 날짜관리(작성,수정일자)
	
//	@ManyToOne
//	private Member author; //Member정보를 가져오기 위함

}
