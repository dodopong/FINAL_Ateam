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
	
	@GetMapping("/list") //FQA/문의 메인 페이지 주소(게시판 형태)
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam(value = "kw",defaultValue = "")String kw) {
		Page<BoardQuestion> paging = this.boardQuestionService.getList(page,kw);
		model.addAttribute("paging",paging);
		model.addAttribute("kw",kw);
		return "boardQuestion_list";
	}
	
	@GetMapping(value = "/detail/{id}") //특정 질문 클릭시 보여주는 상세페이지 주소
	public String detail(Model model , @PathVariable("id") Integer id, BoardAnswerForm boardAnswerForm) {
		BoardQuestion boardQuestion = this.boardQuestionService.getBoardQuestion(id);
		model.addAttribute("boardQuestion",boardQuestion);
		return "boardQuestion_detail";
	}
	
	
	@GetMapping("/create") //FQA/문의 질문작성 주소
	public String boardQuestionCreate(BoardQuestionForm boardQuestionForm) {
		return "boardQuestion_form";
	}
	
	@PostMapping("/create") 
	public String boardQuestionCreate(@Valid BoardQuestionForm boardQuestionForm, BindingResult bindingResult, Principal principal) throws nosignException {
		if(bindingResult.hasErrors()) {
			return "boardQuestion_form"; //오류가 있다면 리파지토리저장 없이 기존의 데이터를 boardQuestion_form.html에 표시
		}
		Member member = this.memberService.getUser(principal.getName()); //글쓴이 정보를 보여주기 위한 코드
		this.boardQuestionService.boardQuestionCreate(boardQuestionForm.getSubject(),boardQuestionForm.getContent(),member);
		return "redirect:/boardQuestion/list";
		//오류가 없다면 boardQuestionService의 boardQuestionCreate로 리파지토리에 값을 저장하고 FQA/문의 게시판 화면으로 넘어간다
	}
	
	
	
	
	
	
	
}
