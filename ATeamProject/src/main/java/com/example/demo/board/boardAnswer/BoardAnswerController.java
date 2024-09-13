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
	
	
	@PostMapping("/create/{id}") //FQA/문의 답변을 작성하는 주소
	public String createBoardAnswer(Model model,@PathVariable("id") Integer id , @Valid BoardAnswerForm boardAnswerForm,BindingResult bindingResult,Principal principal) throws nosignException {
		//사용자가 입력한 내용을 BoardAnswerForm에 넘겨 (유효성)검사한 값을 BindingResult에 담는 구조
		BoardQuestion boardQuestion = this.boardQuestionService.getBoardQuestion(id);
		//boardQuestionService의 getBoardQuestion을 통해 id값을 준 boardQuestion 인스턴스를 생성
		Member member = this.memberService.getUser(principal.getName());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("boardQuestion",boardQuestion);
			return "boardQuestion_detail"; 
			//오류가 있다면 리파지토리저장 없이 기존의 데이터를 boardQuestion_detail.html에 표시
		}
		
		
		this.boardAnswerService.create(boardQuestion, boardAnswerForm.getContent(), member);
		
		return String.format("redirect:/boardQuestion/detail/%s", id);
		//오류가 없다면 boardAnswerService의 create로 리파지토리에 값을 저장하고 질문에 종속시킨다
	}
	
	
}
