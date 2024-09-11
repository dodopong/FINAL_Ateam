package com.example.demo.createQuiz;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.Member;

public interface CreateQuizReposityory extends JpaRepository<CreateQuiz, Integer>{

}
