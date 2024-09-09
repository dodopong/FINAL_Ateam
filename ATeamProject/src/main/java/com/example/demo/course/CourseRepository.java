package com.example.demo.course;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



	public interface CourseRepository extends JpaRepository<Course, Integer> {
		List<Course> findByTitleContaining(String keyword);
		
		List<Course> findByCourseKeyIn(List<String> courseKeys);
//		9월 9일 박호선 결제페이지 정보 출력 목적으로 추가
		Page<Course> findAll(Pageable pageable);
		
		@Query("select "
	            + "distinct c "
	            + "from Course c " 
	            + "where "
	            + "   c.title like %:kw% "
	            + "order by"
	            + "   c.lastUpdateDate desc")
		List<Course> findAllByKeyword(@Param("kw") String kw);
}
