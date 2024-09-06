package com.example.demo.courseReview;

import java.time.LocalDateTime;

import com.example.demo.course.Course;
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
public class CourseReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer crKey;
	
	@Column(length = 100)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Member member;
	
	private String rate;
	
	private LocalDateTime lastUpdateDate;

}
