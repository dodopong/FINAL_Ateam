package com.example.demo.cart;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String cart(
			CourseForm courseForm, Model model,
			Integer id
			) 
//					throws NotFoundException 
	{
//		Cart ca = this.cas.getCart(1);
//		System.out.println(ca);
//		Course co = this.cos.getCourse(id);
//		이거 뭔가 잘못된 것 같은데..
//		에러 500인데 필수 path변수 id가 없다?
//		매핑 주소값에 id를 넣으니 404가 나오는데 주소값에 들어가는 id는 cart의 id일 텐데? getCart도 만들어야 하나?
//		@RequestParam 써야 하나? 근데 이건 id값이 아니라 value 쓰지 않았나?
//		courseForm.setTitle(co.getTitle());
//		courseForm.setCategory(co.getCategory());
//		courseForm.setLevel(co.getLevel());
//		courseForm.setPrice(co.getPrice());
//		model.addAttribute("course", co);
		return "cart";
	}
}
