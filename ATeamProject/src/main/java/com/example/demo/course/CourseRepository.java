package com.example.demo.course;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


	public interface CourseRepository extends JpaRepository<Course, Integer> {
		List<Course> findByTitleContaining(String keyword);
		List<Course> findByCourseKeyIn(List<String> courseKeys);
//		9월 9일 박호선 결제페이지 정보 출력 목적으로 추가

}
