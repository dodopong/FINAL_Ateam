package com.example.demo.board.boardQuestion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardQuestionService {

	private final BoardQuestionRepository boardQuestionRepository;
	
	public List<BoardQuestion> getList(){
		return this.boardQuestionRepository.findAll();
	}
	
	
	public Page<BoardQuestion> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
		return this.boardQuestionRepository.findAll(pageable);
	}
	
	public BoardQuestion getBoardQuestion(Integer id) {
		Optional<BoardQuestion> boardQuestion = this.boardQuestionRepository.findById(id);
		if(boardQuestion.isPresent()) {
			return boardQuestion.get();
		}else {
			throw new DataNotFoundException("boardQuestion not found");
		}
	}
	
	
	public void boardQuestionCreate(String subject ,String content) {
		BoardQuestion q = new BoardQuestion();
		q.setBoardQuestionSubject(subject);
		q.setBoardQuestionContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.boardQuestionRepository.save(q);
	}
	
	
	
	
}
