package com.example.demo.board.boardAnswer;

import java.time.LocalDateTime;

import com.example.demo.board.boardQuestion.BoardQuestion;
import com.example.demo.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoardAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boardAnswerId;
	
	@Column(columnDefinition = "TEXT")
	private String boardAnswerContent;
	
	private LocalDateTime createDate;
	
	@ManyToOne
	private BoardQuestion boardQuestion;
	
	
	
	
	@ManyToOne
	private Member nickname;
	
	
	
	
}
