package com.example.demo.cart;


import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import com.example.demo.course.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		List<Course> coList = this.cos.getCourseAll();
		model.addAttribute("courseList", coList);
		return "cart";
	}
//	장바구니 페이지
	
	@GetMapping("/dlatl")
	public String dlatlPage() {
		return "dlatl";
	}
	
	@PostMapping("/dlatl")
    public String receiveData(@RequestParam(value="data") String data) throws JsonMappingException, JsonProcessingException {
        List<String> coursekeylist = new ObjectMapper().readValue(data, new TypeReference<List<String>>() {});
        System.out.println("받은 배열: " + coursekeylist);
        return "dlatl";
    }
	
	
}