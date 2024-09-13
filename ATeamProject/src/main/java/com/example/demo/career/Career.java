package com.example.demo.career;

import com.example.demo.member.Member;

import jakarta.persistence.Column;
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
public class Career { //강사 커리어 데이터 관리를 위함
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer careerKey;
	
	@Column(columnDefinition = "TEXT")
	private String careerText;
	
	private String year;
	
	@ManyToOne
	private Member member;
	
}
