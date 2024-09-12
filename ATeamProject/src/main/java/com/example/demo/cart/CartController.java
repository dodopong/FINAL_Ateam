package com.example.demo.cart;


import java.security.Principal;
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
	

	
	@GetMapping("/cart/delete/{id}")
	public String delcart(@PathVariable(value = "id")Integer cartKey) {
		try {
			Cart c = this.cas.getCart(cartKey);
			this.cas.delete(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/cart";
	}
  
//	@PreAuthorize("isAuthenticated()")
//	@GetMapping("/cart/{memberKey}")
//	public String cart(@PathVariable("memberKey") Integer memberKey, Model model,
//			           Principal principal) throws NotFoundException, nosignException {
//		
//		Member m2 = this.mes.getUser(principal.getName());
//		
////		int T = Long.valueOf(m2.getMemberKey()).intValue();
////		왜 타입을 바꿔도 안 되지?
//		
////		List<Course> courseList = this.cos.getCourseCart(memberKey);
////		파라미터를 멤버키 타입에 맞게 Long으로 바꾸면 key를 못찾는다고 에러나고
////		파라미터 타입을 다른 걸로 하면 Long이 아니라고 에러나고
////		어떻게 해야 잘 굴러가지?
//		
//		List<Course> courseList = this.cos.getCourseAll();
//		
//		model.addAttribute("courseList", courseList);
//		
//		return "cart";
//	}
//	장바구니 페이지
	

//	@PreAuthorize("isAuthenticated()")
//	@GetMapping("/course/{course_key}/addcart")
//	public String addCart(@PathVariable("course_key") Integer course_key, Principal principal) throws NotFoundException, nosignException {
//		
//		Course co1 = this.cos.getCourse(course_key);
//		Member m1 = this.mes.getUser(principal.getName());
//		
//			co1.getCourseKey();
//			m1.getMemberKey();
//			this.cas.addCart(co1, m1);
//			
//			return String.format("redirect:/course/%s", co1.getCourseKey());
//		
//	}
	
}