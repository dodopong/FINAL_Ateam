package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.boardQuestion.BoardQuestionService;

@SpringBootTest
class ATeamProjectApplicationTests {

	 @Autowired
	    private BoardQuestionService boardQuestionService;

	    @Test
	    void testJpa() {

	    }

}
