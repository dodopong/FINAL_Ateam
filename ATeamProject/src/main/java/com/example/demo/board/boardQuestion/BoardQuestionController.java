package com.example.demo.board.boardQuestion;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.boardAnswer.BoardAnswerForm;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.nosignException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/boardQuestion")
@Controller
@RequiredArgsConstructor
public class BoardQuestionController {
	
	private final BoardQuestionService boardQuestionService;
	private final MemberService memberService;
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "kw",defaultValue = "")String kw) {
		Page<BoardQuestion> paging = this.boardQuestionService.getList(page,kw);
		model.addAttribute("paging",paging);
		model.addAttribute("kw",kw);
		return "boardQuestion_list";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model , @PathVariable("id") Integer id, BoardAnswerForm boardAnswerForm) {
		BoardQuestion boardQuestion = this.boardQuestionService.getBoardQuestion(id);
		model.addAttribute("boardQuestion",boardQuestion);
		return "boardQuestion_detail";
	}
	
	
	@GetMapping("/create")
	public String boardQuestionCreate(BoardQuestionForm boardQuestionForm) {
		return "boardQuestion_form";
	}
	
	@PostMapping("/create")
	public String boardQuestionCreate(@Valid BoardQuestionForm boardQuestionForm, BindingResult bindingResult, Principal principal) throws nosignException {
		if(bindingResult.hasErrors()) {
			return "boardQuestion_form";
		}
		Member member = this.memberService.getUser(principal.getName());
		this.boardQuestionService.boardQuestionCreate(boardQuestionForm.getSubject(),boardQuestionForm.getContent(),member);
		return "redirect:/boardQuestion/list";
	}
	
	
	
	
	
	
	
}
