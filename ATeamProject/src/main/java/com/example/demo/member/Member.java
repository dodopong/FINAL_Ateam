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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberKey;

	@Column(unique = true)
	private String memberId; //기존 member_id에서 memberId로 변경(09.02이민지)
	
	private String password;
	
	private String telNo;
	
	private String birth;
	
	private String mname;
	
	private LocalDateTime createDate;
	
	private String nickname;
	
	private String profileImg;
	
	private String category;
	
	private String instructorYn;
	
	private LocalDateTime lastUpdateDate;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Course> courseList;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Course> CourseReviewList;
	
}
