package com.example.demo.cart;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.course.Course;
import com.example.demo.member.Member;

import jakarta.persistence.CascadeType;
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
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cart_key;
	
	@ManyToOne
	private Course course_key;
	
	@ManyToOne
	private Member member_key;
	
	private LocalDateTime update_date;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courseList;
//	private Course course;

}
