package com.example.demo.board.boardAnswer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.boardQuestion.BoardQuestion;
import com.example.demo.board.boardQuestion.BoardQuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/boardAnswer")
@RequiredArgsConstructor
@Controller
public class BoardAnswerController {

	private final BoardQuestionService boardQuestionService;
	private final BoardAnswerService boardAnswerService;
	
	
	@PostMapping("/create/{id}")
	public String createBoardAnswer(Model model,@PathVariable("id") Integer id , @Valid BoardAnswerForm boardAnswerForm,BindingResult bindingResult) {
		BoardQuestion boardQuestion = this.boardQuestionService.getBoardQuestion(id);
	
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("boardQuestion",boardQuestion);
			return "boardQuestion_detail"; 
		}
		
		
		
		
		this.boardAnswerService.create(boardQuestion, boardAnswerForm.getContent());
		
		return String.format("redirect:/boardQuestion/detail/%s", id);
		
	}
	
	
}
