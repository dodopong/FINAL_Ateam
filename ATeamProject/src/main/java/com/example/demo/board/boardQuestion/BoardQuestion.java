package com.example.demo.board.boardQuestion;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.board.boardAnswer.BoardAnswer;
import com.example.demo.member.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoardQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boardQuestionId;
	
	@Column(length = 200 )
	private String boardQuestionSubject;
	
	@Column(columnDefinition = "TEXT")
	private String boardQuestionContent;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "boardQuestion", cascade = CascadeType.REMOVE)
	private List<BoardAnswer> boardAnswerList;
	
	
	@ManyToOne
	private Member author;
	
	
	
}
