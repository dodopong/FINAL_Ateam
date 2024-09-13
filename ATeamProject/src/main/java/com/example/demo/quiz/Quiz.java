package com.example.demo.quiz;


import java.util.List;

import com.example.demo.member.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizKey;

	private String category; //카테고리 선택
	
	private String quizLevel; //퀴즈 난이도 1~5
	
	@Column(unique = true)
	private String quizTitle; //문제 제목
	
	@Column(columnDefinition = "TEXT")
	private String explanation; //문제 설명
	
	@Column(columnDefinition = "TEXT")
	private String limitation; //제한사항
	
	@Column(columnDefinition = "TEXT")
	private String ioEx; //입출력 예
	
	@Column(columnDefinition = "TEXT")
	private String ioExplanation; //입출력 예 설명
	@Column(columnDefinition = "TEXT")
	private String presentCode; //제시코드
	
	@Column(columnDefinition = "TEXT")
	private String solutionCode; //정답코드
	
	private String quizFile; //문제 참고파일(강사가 업로드하는 파일)
							 //추후 타입 변경 필요
	@ManyToOne
	private Member member;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.REMOVE) 
    private List<QuizStudent> submitCodeList; 
	
//	@ManyToOne
//	private Member author; //Member정보를 가져오기 위함

}
