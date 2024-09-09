package com.example.demo.board.boardAnswer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.board.boardQuestion.BoardQuestion;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardAnswerService {
	
	private final BoardAnswerRepository boardAnswerRepository;
	
	public void create(BoardQuestion boardQuestion,String content) {
		BoardAnswer boardanswer = new BoardAnswer();
		boardanswer.setBoardAnswerContent(content);
		boardanswer.setCreateDate(LocalDateTime.now());
		boardanswer.setBoardQuestion(boardQuestion);
		this.boardAnswerRepository.save(boardanswer);
	}
	
	
}
