package com.example.demo.quiz;

import java.time.LocalDateTime;
import java.util.List;

//import com.example.demo.Question;
//import com.example.demo.Answer;
//import com.example.demo.SiteUser;
import com.example.demo.course.Course;

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
public class Quiz { //맴버의 정보 필요

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizKey;

//	@Column(unique = true)
	private String title; //강의course 제목
	
	private String quizTitle; //문제 제목
	
	private String explain; //문제 설명
	
	private String limit; //제한사항
	
	private String io; //입출력 예
	
	private String ioExplain; //입출력 예 설명
	
	private String present; //제시코드
	
	private String solution; //정답코드
	
	private String quizFile; //문제 참고파일(강사가 업로드하는 파일)
	
	private String submitCode; //(수강생)제출코드
		
	private LocalDateTime qDate; //질문 날짜관리(작성,수정일자)
	
	private LocalDateTime aDate; //답변 날짜관리(작성,수정일자)
	
	//mappedBy => 설정되지 않은 쪽이 주인(테이블 관리 가능) , 설정된 쪽은 조회만 가능									
//	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
//	private List<QuizAnswer> quizAnswerList;
//	
//	@ManyToOne
//	private List<QuizQuestion> quizQuestionList;
	
	
	private Integer challenge; //도전한 문제(제출코드의 수)
	
	private Integer guess; //맞춘 문제
	
	private Integer run; //(수강생)총 실행 횟수
	

//	@ManyToOne
//	private Member author; //Member정보를 가져오기 위함
	
//	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//	private List<Course> courseList;
//	
//	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//	private List<Course> CourseReviewList;
	
//  private String delYn; 현업에서는 관리자 삭제권한 필요
}
