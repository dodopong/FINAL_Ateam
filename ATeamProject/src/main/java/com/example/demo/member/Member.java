package com.example.demo.member;
import com.example.demo.course.Course;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
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

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long member_key;

	@Column(unique = true)
	private String memberId; //기존 member_id에서 memberId로 변경(09.02이민지)
	
	private String password;
	
	private String tel_no;
	
	private String birth;
	
	private String mname;
	
	private LocalDateTime create_date;
	
	private String nickname;
	
	private String profile_img;
	
	private String category;
	
	private String instructor_yn;
	
	private LocalDateTime last_update_date;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Course> courseList;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Course> CourseReviewList;
	
}
