package com.example.demo.cart;


import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import com.example.demo.course.NotFoundException;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.nosignException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CartController {
	
	private final CartService cas;
	private final CourseService cos;
	private final MemberService mes;
	
//	@PreAuthorize("isAuthenticated()")
//	시큐리티에 로그인 페이지 지정시 넣기
	
	@GetMapping("/cart")
	public String cart(Model model, Member id) throws NotFoundException {
		List<Course> coList = this.cos.getCourseAll();
		model.addAttribute("courseList", coList);
		
//		List<Cart> cart = cas.checkCart(id);
//		System.out.println(cart);
		
		return "cart";
	}
//	장바구니 페이지
	
	
}