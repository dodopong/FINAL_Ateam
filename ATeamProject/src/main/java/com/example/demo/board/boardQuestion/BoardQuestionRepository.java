package com.example.demo.board.boardQuestion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardQuestionRepository extends JpaRepository<BoardQuestion, Integer>{

	BoardQuestion findByBoardQuestionSubject(String boardQuestionSubject);
	BoardQuestion findByBoardQuestionSubjectAndBoardQuestionContent(String boardQuestionSubject,String boardQuestionContent);
	List<BoardQuestion> findByBoardQuestionSubjectLike(String boardQuestionSubject);
	Page<BoardQuestion> findAll(Pageable pageable);
}
