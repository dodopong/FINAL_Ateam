package com.example.demo.cart;


import java.util.List;

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
	
	
	@GetMapping("/cart")
	public String cart(CourseForm courseForm, Model model) throws NotFoundException {
//		Cart ca = this.cas.getCart(1);
//		Course co = this.cos.getCourse(1);
		List<Course> coList = this.cos.getCourseAll();
//		나중에 Cart랑 Member id도 연관되게 만들어야 함
		
		
		
		
		model.addAttribute("courseList", coList);
		return "cart";
	}
	
	
}