package com.example.demo.course;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


	public interface CourseRepository extends JpaRepository<Course, Integer> {
		List<Course> findByTitleContaining(String keyword);
}
