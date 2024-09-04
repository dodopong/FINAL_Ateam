package com.example.demo.courseReview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import com.example.demo.course.NotFoundException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CourseReviewController {
	
	private final  CourseReviewService crs;
	private final CourseService cs;
	
	@GetMapping("/course/{course_key}/reviewcreate")
		public String createCourseReview(Model model, CourseReviewForm courseReviewForm, 
				@PathVariable("course_key")Integer course_key) throws NotFoundException{
				Course c = this.cs.getCourse(course_key);
				model.addAttribute("course",c);
		return "CreateCourseReview";
	}
	
	@PostMapping("/course/{course_key}/reviewcreate")
	public String createCourseReview(Model model, @PathVariable("course_key") Integer course_key,
			@Valid CourseReviewForm courseReviewForm, BindingResult bindingResult) throws NotFoundException {
		Course c = this.cs.getCourse(course_key);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("course",c);
			return "CreateCourseReview";
		}
		this.crs.create(c, courseReviewForm.getTitle(), courseReviewForm.getContent(), courseReviewForm.getRate());	
		return String.format("redirect:/course/%s", course_key);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
