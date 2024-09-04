package com.example.demo.member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어 줌
@Controller
public class MemberController {
	
	private final MemberService ms;
	
	
//	@GetMapping("/login") //로그인
//	public String login() {
//		return "Mainpage"; //로그인 기능이 메인페이지 모달창으로 되어있어서 어디로 리턴해야 하지..?
//	}
	
	
	@GetMapping(value = "/join") //회원가입
	public String userCreate(MemberForm memberForm) {
		return "join";
	}
	
	@PostMapping("/join")
	public String signup(@Valid MemberForm memberForm, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return "join";
		}
		
		//비밀번호=!비밀번호확인
		if(!memberForm.getPassword1().equals(memberForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect",
					"패스워드가 일치하지 않습니다.");
			return "join"; //에러가 있는경우 반환할 뷰
		}
		
		try {
			this.ms.create(memberForm.getEmail1(),
						   memberForm.getEmail2(),
						   memberForm.getPassword1(),
						   memberForm.getMname(),
						   memberForm.getTel_no(),
						   memberForm.getNickname(),
						   memberForm.getBirth(),
						   memberForm.getProfile_img(),
						   memberForm.getCategory(),
						   memberForm.getInstructor_yn());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "join"; //에러가 있는경우 반환할 뷰
		}

		return "Mainpage"; //변경필요
	}
	
	
	
	
	
	
	
	
	
	
	
}
