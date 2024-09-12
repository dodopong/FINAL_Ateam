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
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.nosignException;

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
	
	
//---------------------MAIN PAGE--------------------------
	@GetMapping("/main")
	public String viewMain(Model model) {
		List<Course> clist = this.cs.getCourseAll();
		model.addAttribute("courseList",clist);
		return "MainPage";
	}
//---------------------------------------------------------
	@GetMapping("/createReview")
	public String createCoureReview() {
		return "CreateCourseReview";
	}
	
//-------------------------------------create-------------
	@PreAuthorize("isAuthenticated()") // 로그인 한 경우에만 요청 처리
	@GetMapping("/create")
	public String createCoure(CourseForm courseForm, Principal principal) throws nosignException {
		Member m = this.ms.getUser(principal.getName());
		if(m.getInstructorYn().equals("N") || m.getInstructorYn()==null) {
			return "redirect:/main";
		}
		else {
			return "CreateCourse";
		}
	}
	
	@PreAuthorize(value = "isAuthenticated()")
	@PostMapping("/create")
	public String createCoure(CourseForm courseForm, BindingResult bindingResult,
			HttpServletRequest request, @RequestParam(value = "file1") MultipartFile file1,
			@RequestParam(value = "file2") MultipartFile file2, Principal principal) throws Exception{
		 if (bindingResult.hasErrors()) {
		        for (FieldError error : bindingResult.getFieldErrors()) {
		            System.out.println("Field: " + error.getField());
		            System.out.println("Error Code: " + error.getCode());
		            System.out.println("Default Message: " + error.getDefaultMessage());
		        }
		        return "CreateCourse"; // 에러가 있는 경우 반환할 뷰
		    }
		 Member m = this.ms.getUser(principal.getName());
	     Course c = this.cs.returnCreate(courseForm.getTitle(),courseForm.getMainContent(),courseForm.getBannerText()
	    		   ,courseForm.getCategory(),courseForm.getLevel(),courseForm.getObjective(),courseForm.getPrice(),m);
	      
	       
	     fc.thumbfileInsert(request, file1, c);
	     fc.bannerfileInsert(request, file2, c);
	     return "redirect:/user/mypage/mycourse";
	}

//-----------------------------------------------------------------------------------------
//-------------------------------SearchCourse-----------------------------
	@GetMapping("/searchcourse")
	
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
//---------------------------------CourseRegistration------------------
	@GetMapping(value = "/course/{course_key}")
	   public String detail(Model model, @PathVariable("course_key") Integer course_key, CourseForm courseForm) throws NotFoundException {
	      Course c = this.cs.getCourse(course_key);
	      Member m = c.getMember();
	      model.addAttribute("course", c);
	      model.addAttribute("member",m);
	      return "CourseRegistration";
	   }
	//------------------------------------장바구니 관련-----------------
	
	@GetMapping("/course/{courseKey}/addcart")
	public String addcart(@PathVariable(value = "courseKey")Integer courseKey, Model model, Principal principal) throws Exception {
		Member m = this.ms.getUser(principal.getName());
		Course c = this.cs.getCourse(courseKey);
		
		try {
			Cart ct = this.carts.getCart(m.getMemberKey(), courseKey);
			if(!m.getCartList().contains(ct)) {
				this.carts.createCart(m, c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			this.carts.createCart(m, c);
		}
		
		model.addAttribute("member", m);
		
		return "Cart";
	}
	
	@GetMapping("/cart")
	public String viewcart(Model model, Principal principal) throws Exception {
		Member m = this.ms.getUser(principal.getName());
		
		model.addAttribute("member", m);
		
		return "Cart";
	}
} 
