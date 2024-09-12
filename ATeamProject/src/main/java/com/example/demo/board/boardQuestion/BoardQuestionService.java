package com.example.demo.board.boardQuestion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.board.DataNotFoundException;
import com.example.demo.board.boardAnswer.BoardAnswer;
import com.example.demo.member.Member;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardQuestionService {

	private final BoardQuestionRepository boardQuestionRepository;
	
	private Specification<BoardQuestion> search(String kw){
		return new Specification<BoardQuestion>() {
			@Override
            public Predicate toPredicate(Root<BoardQuestion> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				Join<BoardQuestion, BoardAnswer> a = q.join("boardAnswerList",JoinType.LEFT);
				 return cb.or(cb.like(q.get("boardQuestionSubject"), "%" + kw + "%"), // 제목 
	                        cb.like(q.get("boardQuestionContent"), "%" + kw + "%"), // 내용 
	                        cb.like(a.get("boardAnswerContent"), "%" + kw + "%"));      // 답변 내용 
			}
		};
	}

	public List<BoardQuestion> getList(){
		return this.boardQuestionRepository.findAll();
	}
	
	public Page<BoardQuestion> getList(int page , String kw){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
		
		Specification<BoardQuestion> spec = search(kw);
		return this.boardQuestionRepository.findAll(spec,pageable);
	}
	
	public BoardQuestion getBoardQuestion(Integer id) {
		Optional<BoardQuestion> boardQuestion = this.boardQuestionRepository.findById(id);
		if(boardQuestion.isPresent()) {
			return boardQuestion.get();
		}else {
			throw new DataNotFoundException("boardQuestion not found");
		}
	}
	
	
	public void boardQuestionCreate(String subject ,String content, Member member) {
		BoardQuestion q = new BoardQuestion();
		q.setBoardQuestionSubject(subject);
		q.setBoardQuestionContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(member);
		this.boardQuestionRepository.save(q);
	}
	
	
	
	
}
