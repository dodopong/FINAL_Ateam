package com.example.demo.course;

import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.cart.Cart;
import com.example.demo.courseReview.CourseReview;
import com.example.demo.file.Files;
import com.example.demo.lecture.Lecture;
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
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseKey;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String mainContent;
	
	@Column(columnDefinition = "TEXT")
	private String bannerText;
	
	private String category;
	private String level;
	
	@Column(columnDefinition = "TEXT")
	private String Objective;
	
	private String price;
	
	private LocalDateTime lastUpdateDate;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Lecture> lectureList;
	
	@ManyToOne
	private Member member;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Files> fileList;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
	private List<Cart> cartList;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<CourseReview> courseReviewList;
	
}
