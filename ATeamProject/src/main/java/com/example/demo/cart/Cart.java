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
	//실험좀 하자
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartKey;
	
	@ManyToOne
	private Course courseKey;
	
	@ManyToOne
	private Member memberKey;
	
	private LocalDateTime updateDate;
	
	private LocalDateTime lastUpdateDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courseList;
//	private Course course;

}
