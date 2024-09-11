package com.example.demo.member;
import com.example.demo.career.Career;
import com.example.demo.course.Course;
import com.example.demo.courseReview.CourseReview;
import com.example.demo.file.Files;

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
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberKey;

	@Column(unique = true)
	private String memberId;
	
	private String password;
	
	private String telNo;
	
	private String birth;
	
	private String mname;
	
	private LocalDateTime createDate;
	
	private String nickname;
	
	
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private Files profileImg;
	
	private String category;
	
	private String instructorYn;
	
	private LocalDateTime lastUpdateDate;
	
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Course> courseList;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<CourseReview> CourseReviewList;
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Career> careerList;
	
}
