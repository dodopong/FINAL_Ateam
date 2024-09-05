package com.example.demo.cart;


import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.course.Course;
import com.example.demo.course.CourseForm;
import com.example.demo.course.CourseService;
import com.example.demo.course.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CartController {
	
	private final CartService cas;
	private final CourseService cos;
	
//	@PreAuthorize("isAuthenticated()")
//	시큐리티에 로그인 페이지 지정시 넣기
	@GetMapping("/cart")
	public String cart(Model model) throws NotFoundException {
//		Cart ca = this.cas.getCart(1);
		List<Course> coList = this.cos.getCourseAll();
		
		model.addAttribute("courseList", coList);
		return "cart";
	}
	
//	public String createCart() {
//		
//	}
	
	
}