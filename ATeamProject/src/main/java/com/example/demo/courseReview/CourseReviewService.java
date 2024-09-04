package com.example.demo.courseReview;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.course.Course;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseReviewService {
	
	private final CourseReviewRepository cv;
	
	public CourseReview getCourseReview(Integer cr_key) throws CanNotFoundException{
		Optional<CourseReview>c3 = this.cv.findById(cr_key);
		if(c3.isPresent()) {
			return c3.get();
		}
		else {
			throw new CanNotFoundException("데이터를 찾을 수 없습니다.");
		}
		
	}
	
	public void create(Course course, String title, String content, String rate) {
		CourseReview rev = new CourseReview();
		rev.setTitle(title);
		rev.setContent(content);
		rev.setRate(rate);
		rev.setLast_update_date(LocalDateTime.now());
		rev.setCourse(course);
		
		this.cv.save(rev);
		
	}

}
