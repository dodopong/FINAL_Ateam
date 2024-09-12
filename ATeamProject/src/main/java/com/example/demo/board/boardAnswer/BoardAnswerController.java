package com.example.demo.board.boardAnswer;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.boardQuestion.BoardQuestion;
import com.example.demo.board.boardQuestion.BoardQuestionService;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.nosignException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/boardAnswer")
@RequiredArgsConstructor
@Controller
public class BoardAnswerController {

	private final BoardQuestionService boardQuestionService;
	private final BoardAnswerService boardAnswerService;
	private final MemberService memberService;
	
	
	@PostMapping("/create/{id}")
	public String createBoardAnswer(Model model,@PathVariable("id") Integer id , @Valid BoardAnswerForm boardAnswerForm,BindingResult bindingResult,Principal principal) throws nosignException {
		BoardQuestion boardQuestion = this.boardQuestionService.getBoardQuestion(id);
		Member member = this.memberService.getUser(principal.getName());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("boardQuestion",boardQuestion);
			return "boardQuestion_detail"; 
		}
		
		
		this.boardAnswerService.create(boardQuestion, boardAnswerForm.getContent(), member);
		
		return String.format("redirect:/boardQuestion/detail/%s", id);
		
	}
	
	
}
