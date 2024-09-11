package com.example.demo.course;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService {
	private final CourseRepository cr;
	
	public Page<Course> getCourseAll(int page){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("lastUpdateDate"));
		Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));
		return this.cr.findAll(pageable);
	}
	
	public List<Course> getCourseAll(){
		return this.cr.findAll();
	}
	
	
//	public List<Course> search(String keyword){
//		return this.cr.findByTitleContaining(keyword);
//	}
	
	public List<Course> search(String keyword){
		return this.cr.findAllByKeyword(keyword);
	}

	public List<Course> getListCourse(List<String> coursekeyList){
		
		return this.cr.findByCourseKeyIn(coursekeyList);
	}
//	9월 9일 박호선 결제페이지 정보 출력 목적으로 추가

	
	
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
			,String Objective, String price, Member m) {
		Course c = new Course();
		c.setTitle(title);
		c.setMainContent(main_content);
		c.setBannerText(banner_text);
		c.setCategory(category);
		c.setLevel(level);
		c.setPrice(price);
		c.setObjective(Objective);
		c.setLastUpdateDate(LocalDateTime.now());
		c.setMember(m);
		
		this.cr.save(c);
		return c;
	}
	
	public void create(String title, String main_content, String banner_text,String category,String level
			,String Objective, String price) {
		Course c = new Course();
		c.setTitle(title);
		c.setMainContent(main_content);
		c.setBannerText(banner_text);
		c.setCategory(category);
		c.setLevel(level);
		c.setPrice(price);
		c.setObjective(Objective);
		c.setLastUpdateDate(LocalDateTime.now());
		
		this.cr.save(c);
	}
}
