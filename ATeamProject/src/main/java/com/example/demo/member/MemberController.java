package com.example.demo.member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어 줌
@Controller
@RequestMapping("/user")
public class MemberController {
	
	private final MemberService ms;	
	
    @GetMapping("/login") //로그인
    public String login() {
        return "login";
    }
	
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
		
		try { //잘 안먹는거 같음 같은 이메일로 회원가입 두번 됨
			this.ms.create(memberForm.getEmail1(),
						   memberForm.getEmail2(),
						   memberForm.getPassword1(),
						   memberForm.getMname(),
						   memberForm.getTelNo(),
						   memberForm.getNickname(),
						   memberForm.getBirth(),
						   memberForm.getProfileImg(),
						   memberForm.getCategory(),
						   memberForm.getInstructorYn());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "join"; //에러가 있는경우 반환할 뷰
		} catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage()); //그 밖에 다른 예외들은 해당 예외에 관한 구체적인 오류 메시지를 출력
            return "join";
        }

		return "redirect:/main"; //변경필요
	}
	
	
	
}
