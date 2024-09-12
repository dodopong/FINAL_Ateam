package com.example.demo.cart;

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
public class Cart {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer cartKey;

	 @ManyToOne
	 private Member member; // 장바구니 소유자

	 @ManyToOne
	 private Course course; // 장바구니에 담긴 강좌

}