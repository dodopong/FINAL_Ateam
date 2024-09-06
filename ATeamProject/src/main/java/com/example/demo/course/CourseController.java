package com.example.demo.course;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.PpakchimException;
import com.example.demo.file.FileController;
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
	
//---------------------MAIN PAGE--------------------------
	@GetMapping("/main")
	public String viewMain() {
		return "MainPage";
	}
//---------------------------------------------------------
	@GetMapping("/createReview")
	public String createCoureReview() {
		return "CreateCourseReview";
	}
	
//-------------------------------------create-------------
	@GetMapping("/create")
	public String createCoure(CourseForm courseForm) {
		return "CreateCourse";
	}
	
	@PostMapping("/create")
	public String createCoure(CourseForm courseForm, BindingResult bindingResult,
			HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) throws Exception{
		 if (bindingResult.hasErrors()) {
		        for (FieldError error : bindingResult.getFieldErrors()) {
		            System.out.println("Field: " + error.getField());
		            System.out.println("Error Code: " + error.getCode());
		            System.out.println("Default Message: " + error.getDefaultMessage());
		        }
		        return "CreateCourse"; // 에러가 있는 경우 반환할 뷰
		    }
	      Course c = this.cs.returnCreate(courseForm.getTitle(),courseForm.getMainContent(),courseForm.getBannerText()
	    		   ,courseForm.getCategory(),courseForm.getLevel(),courseForm.getObjective());
	      
	       
	       fc.fileInsert(request, file, c);
	       return "redirect:/create";
	}
//-----------------------------------------------------------------------------------------
//-------------------------------SearchCourse-----------------------------
	@GetMapping("/searchcourse")
	
	public String searchCourse(@RequestParam(value ="keyword")String keyword, Model model,CourseForm courForm) throws PpakchimException {
		List<Course> clist = this.cs.search(keyword);
		model.addAttribute("courseList", clist);
		return "SearchCourse";
	}
	
//---------------------------------CourseRegistration------------------
	@GetMapping(value = "/course/{course_key}")
	   public String detail(Model model, @PathVariable("course_key") Integer course_key, CourseForm courseForm) throws NotFoundException {
	      Course c = this.cs.getCourse(course_key);
	      model.addAttribute("course", c);
	      return "CourseRegistration";
	   }
} 
