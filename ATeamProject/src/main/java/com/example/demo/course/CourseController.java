package com.example.demo.course;


import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.PpakchimException;
import com.example.demo.cart.Cart;
import com.example.demo.cart.CartService;
import com.example.demo.file.FileController;
import com.example.demo.lecture.Lecture;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.nosignException;
import com.example.demo.registration.Registration;
import com.example.demo.registration.RegistrationService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CourseController {
	private final CourseService cs;
	private final FileController fc;
	private final MemberService ms;
	private final CartService carts;
	private final RegistrationService rs;
	
	
//---------------------MAIN PAGE--------------------------
	@GetMapping("/main")
	public String viewMain(Model model) {
		List<Course> clist = this.cs.getCourseAll();
		model.addAttribute("courseList",clist);
		return "MainPage";
	}
//---------------------리뷰 작성-----------------------------
	@GetMapping("/createReview")
	public String createCoureReview() {
		return "CreateCourseReview";
	}
	
//----------------------강의 생성---------------------------
	@PreAuthorize("isAuthenticated()") // 로그인 한 경우에만 요청 처리
	@GetMapping("/create")
	public String createCoure(CourseForm courseForm, Principal principal) throws nosignException {
		Member m = this.ms.getUser(principal.getName()); //강의 생성자 정보(이름) 저장을 위함
		if(m.getInstructorYn().equals("N") || m.getInstructorYn()==null) { //InstructorYn 컬럼값이 N(학생)인 경우 메인화면으로 돌아감
			return "redirect:/main";
		}
		else {
			return "CreateCourse";
		}
	}
	
	@PreAuthorize(value = "isAuthenticated()") // 로그인 한 경우에만 요청 처리
	@PostMapping("/create")
	public String createCoure(CourseForm courseForm, BindingResult bindingResult,
			HttpServletRequest request, @RequestParam(value = "file1") MultipartFile file1,
			@RequestParam(value = "file2") MultipartFile file2, Principal principal) throws Exception{
		 if (bindingResult.hasErrors()) {
//		        for (FieldError error : bindingResult.getFieldErrors()) {
//		            System.out.println("Field: " + error.getField());
//		            System.out.println("Error Code: " + error.getCode());
//		            System.out.println("Default Message: " + error.getDefaultMessage());
//		        }
		        return "CreateCourse"; // 에러가 있는 경우 반환할 뷰
		    }
		 Member m = this.ms.getUser(principal.getName());
	     Course c = this.cs.returnCreate(courseForm.getTitle(),courseForm.getMainContent(),courseForm.getBannerText()
	    		   ,courseForm.getCategory(),courseForm.getLevel(),courseForm.getObjective(),courseForm.getPrice(),m);
	      
	       
	     fc.thumbfileInsert(request, file1, c);  //썸네일 이미지 저장 메소드
	     fc.bannerfileInsert(request, file2, c); //배너 이미지 저장 메소드
	     return "redirect:/user/mypage/mycourse"; //마이페이지 강의관리페이지로 넘어감
	}
	//-----------------------------------------------------------------------------------------
	//-------------------------------modify course-----------------------------
	@PreAuthorize(value = "isAuthenticated()")
	@GetMapping("/course/{courseKey}/modify")
	public String modifyCourse(@PathVariable(value = "courseKey")Integer courseKey,Principal principal) throws Exception {
		Member m = this.ms.getUser(principal.getName());
		Course c = this.cs.getCourse(courseKey);
		
		return "gongsajoong";
	}
	
	
	
	
	
	
//-----------------------------------------------------------------------------------------
//-------------------------------SearchCourse-----------------------------
	@GetMapping("/searchcourse") //강의 검색
	public String searchCourse(@RequestParam(value ="keyword")String keyword, Model model,CourseForm courForm) throws PpakchimException {
		List<Course> clist = this.cs.search(keyword);
		model.addAttribute("courseList", clist);
		keyword = "\' "+keyword+" \'";
		model.addAttribute("kw",keyword);
		return "SearchCourse";
	}

	@GetMapping("/search")
	public String search(Model model,CourseForm courForm) {
		
		return "SearchCourse";
	}
	
//---------------------------------CourseRegistration------------------------------------------------
	@GetMapping(value = "/course/{course_key}")
	   public String detail(Model model, @PathVariable("course_key") Integer course_key, CourseForm courseForm) throws Exception {
	      Course c = this.cs.getCourse(course_key);
	      if(!c.getLectureList().isEmpty()) {
	    	  Lecture l = c.getLectureList().get(0);
	    	  model.addAttribute("firstLecture",l);
	      }
	      else {
	    	  Lecture l = new Lecture();
	    	  model.addAttribute("firstLecture",l);
	      }
	      Member m = c.getMember();
	      model.addAttribute("course", c);
	      model.addAttribute("member",m);
	     
	      
	      return "CourseRegistration";
	   }

	//------------------------------------장바구니 관련-----------------
	
	@GetMapping("/course/{courseKey}/addcart") // 장바구니 추가 & 장바구니 전체보기
	public String addcart(@PathVariable(value = "courseKey")Integer courseKey, Model model, Principal principal) throws Exception {
		Member m = this.ms.getUser(principal.getName()); //장바구니는 개인별로 가지고 있기 때문에 유저 정보가 필요함
		Course c = this.cs.getCourse(courseKey);         //선택한 강의의 정보가 필효함
		
		try {
			Cart ct = this.carts.getCart(m.getMemberKey(), courseKey);
			if(!m.getCartList().contains(ct)) { //선택한 강의가 카트에 없다면
				this.carts.createCart(m, c);    //카트에 강의 추가
			}
		} catch (Exception e) {
			// 
			this.carts.createCart(m, c);  
		}
		
		model.addAttribute("member", m); 
		
		return "Cart";  
	}
	
	@GetMapping("/cart") // 장바구니 전체보기
	public String viewcart(Model model, Principal principal) throws Exception {
		Member m = this.ms.getUser(principal.getName());
		
		model.addAttribute("member", m);
		
		return "Cart";
	}
	
	//------------------------------------강의 수강 관련-----------------
	
	@GetMapping("/course/registration/{courseKey}")
	public String registration(Model model, @PathVariable(value = "courseKey")Integer courseKey,Principal principal) throws Exception {
		Member m = this.ms.getUser(principal.getName());
		Course c = this.cs.getCourse(courseKey);
		String errm = "수강신청이 완료되었습니다.";
	
		try {
			Registration r = this.rs.getRegistration(m.getMemberKey(), courseKey);
			if(!m.getRegiList().contains(r)) { //특정 강의를 수강하지 않는 상태라면
				this.rs.create(m, c);          //맴버 별로 수강하는 강의 정보를 저장하는 메소드를 호출
			}
			else {
				errm = "이미 수강중인 강의 입니다."; //수강 중이라면 띄우는 메세지
			}
		} catch (Exception e) {
			//
			this.rs.create(m, c);
		}
			model.addAttribute("errM",errm);

		return "redirect:/course/"+Integer.toString(courseKey);
	}
} 
