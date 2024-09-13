package com.example.demo.member;

import java.security.Principal;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.career.Career;
import com.example.demo.career.CareerForm;
import com.example.demo.career.CareerService;

import com.example.demo.course.Course;
import com.example.demo.course.CourseForm;
import com.example.demo.course.NotFoundException;

import com.example.demo.file.FileController;
import com.example.demo.file.Files;
import com.example.demo.file.FilesService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어 줌
@Controller
@RequestMapping("/user")
public class MemberController {
	
	private final MemberService ms;
	private final FilesService fs;
	private final CareerService cs;
	
	@GetMapping("/logintest")
	public String logintest() {
		return "login";
	}
	
    @GetMapping("/login") //로그인
    public String login() {
        return "login";
    }
	
    
	@GetMapping(value = "/join") //회원가입
	public String userCreate(MemberForm memberForm) {
		return "join";
	}
	
    
	@PostMapping("/join")
	public String signup(@Valid MemberForm memberForm, BindingResult bindingResult,
			HttpServletRequest request,@RequestParam(value = "profileImg") MultipartFile file1) throws Exception {

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
			Member m = this.ms.returncreate(memberForm.getEmail1(),
						   memberForm.getEmail2(),
						   memberForm.getPassword1(),
						   memberForm.getMname(),
						   memberForm.getTelNo(),
						   memberForm.getNickname(),
						   memberForm.getBirth(),
						   memberForm.getCategory(),
						   memberForm.getInstructorYn());
			
			fs.save(request, file1, m);// 프로필 이미지 사진 저장
			
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
	
		/////////////////////////MyPage 내정보 관리///	//////////////
    @PreAuthorize(value = "isAuthenticated()")
	@GetMapping("/mypage")
	public String mypage(Model model, Principal principal, MemberForm memberForm) throws nosignException {
		Member m = this.ms.getUser(principal.getName());
		System.out.println(principal.getName());
		model.addAttribute("member",m);
		return "mypage/Mypage";
	}
    
    ///////////내 정보 수정///////////////////////

    @PreAuthorize(value = "isAuthenticated()")
	@GetMapping("/mypage/edit")
	public String modifymypage(MemberForm memberForm,Principal principal,Model model) throws Exception {
    	Member m = this.ms.getUser(principal.getName());
    	model.addAttribute("member", m);
    	return "mypage/MypageEdit";
    }
    
    @PreAuthorize(value = "isAuthenticated()")
	@PostMapping("/mypage/edit")
	public String Modifymypage(MemberForm memberform, Principal principal,
			HttpServletRequest request,@RequestParam(value = "profileImg") MultipartFile file1,Model model) throws Exception {
    	Member m = this.ms.getUser(principal.getName());
    	model.addAttribute("member",m);
		Files f = m.getProfileImg();
		if(!memberform.getNickname().isEmpty()) {
			this.ms.modify(m, memberform.getNickname());
		}
		if(!file1.getOriginalFilename().isEmpty()) {
			this.fs.modifyProfileImg(f, request, file1);
		}
			
		return "redirect:/user/mypage";
	}
    		/////////////////////////MyPage 내 강의 관리(강사계정) //////////////////
    @PreAuthorize(value = "isAuthenticated()")
	@GetMapping("/mypage/mycourse")
	public String mycourse(Model model, Principal principal) throws nosignException {
		Member m = this.ms.getUser(principal.getName());
		model.addAttribute("member",m);
		return "mypage/Mycourse";
	}
    
	/////////////////////////MyPage 수강중인 강의관리 //////////////////
    @PreAuthorize(value = "isAuthenticated()")
    @GetMapping("/mypage/myregistration")
    public String myregistration(Model model, Principal principal) throws nosignException {
    	Member m = this.ms.getUser(principal.getName());
    	model.addAttribute("member",m);
    	return "mypage/Myregistration";
    }
    		/////////////////////////MyPage 내 이력 관리(강사계정) //////////////////
    @PreAuthorize(value = "isAuthenticated()")
    @GetMapping("/mypage/mycareer")
	public String mycareer(Model model, Principal principal,CareerForm careerForm) throws nosignException {
		Member m = this.ms.getUser(principal.getName());
		model.addAttribute("member",m);
		return "mypage/Mycareer";
	}
    @PreAuthorize(value = "isAuthenticated()")
    @PostMapping("/mypage/mycareer")
    public String mycareer(Principal principal,@Valid CareerForm careerForm,BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
			return "mypage/Mycareer";
		}
    	try {
    		Member m = this.ms.getUser(principal.getName());
    		this.cs.create(careerForm.getCareerText(), careerForm.getYear(), m);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return "redirect:/user/mypage/mycareer"; 
    }

}
