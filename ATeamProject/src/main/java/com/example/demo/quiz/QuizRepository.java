package com.example.demo.quiz;

import org.springframework.data.jpa.repository.JpaRepository;

//Reposityory: 생성된 데이터베이스 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스
//Quiz 엔티티로 리포지터리를 생성한다는 의미
public interface QuizRepository extends JpaRepository<Quiz, Integer>{
	
}
