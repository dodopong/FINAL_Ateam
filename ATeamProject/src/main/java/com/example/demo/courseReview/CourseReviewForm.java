package com.example.demo.courseReview;

import com.example.demo.course.Course;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseReviewForm {
	
	@NotEmpty(message = "제목을 입력해주세요.")
	@Size(max=100)
	private String title;
	
	@NotEmpty(message = "내용을 입력해주세요.")
	@Size(max = 300)
	private String content;
	
	@NotEmpty(message = "평점을 선택해주세요.")
	private String rate;

}
