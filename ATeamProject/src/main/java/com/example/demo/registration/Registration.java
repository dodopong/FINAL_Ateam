package com.example.demo.registration;

import com.example.demo.course.Course;
import com.example.demo.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer registrationKey;
	
	@ManyToOne
	public Member member; // 수강중인 회원
	
	@ManyToOne
	public Course course; // 강좌
}
