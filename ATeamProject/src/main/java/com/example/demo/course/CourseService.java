package com.example.demo.course;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.PpakchimException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService {
	private final CourseRepository cr;
	
	public List<Course> getCourseAll(){
		return this.cr.findAll();
	}
	
	public Course getCourse(Integer course_key) throws NotFoundException {
		Optional<Course> c1 = this.cr.findById(course_key);
		if(c1.isPresent()) {
			return c1.get();
		}
		else {
			throw new NotFoundException("데이터를 찾을 수 없습니다.");
		}
	}
	
	public Course returnCreate(String title, String main_content, String banner_text,String category,String level
			,String Objective) {
		Course c = new Course();
		c.setTitle(title);
		c.setMain_content(main_content);
		c.setBanner_text(banner_text);
		c.setCategory(category);
		c.setLevel(level);
		c.setObjective(Objective);
		c.setLast_update_date(LocalDateTime.now());
		
		this.cr.save(c);
		return c;
	}
	
	public void create(String title, String main_content, String banner_text,String category,String level
			,String Objective) {
		Course c = new Course();
		c.setTitle(title);
		c.setMain_content(main_content);
		c.setBanner_text(banner_text);
		c.setCategory(category);
		c.setLevel(level);
		c.setObjective(Objective);
		c.setLast_update_date(LocalDateTime.now());
		
		this.cr.save(c);
	}
}
