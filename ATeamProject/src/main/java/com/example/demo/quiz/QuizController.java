package com.example.demo.quiz;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.nosignException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuizController {
	
	public final QuizService qs;
	private final QuizRepository qr;
	//private final QuizQuestionRepository qqr;
	private final MemberService ms; //필요한가?
	
//------------퀴즈만들기 페이지(강사)--------------------------------------------
	@PreAuthorize("isAuthenticated()") //로그인해야 이용 가능
	@GetMapping(value = "/createquiz") 
	public String createquiz(QuizForm createQuiz) {
		return "CreateQuiz";
	}
	
	
	@PreAuthorize("isAuthenticated()") //로그인해야 이용 가능
	@PostMapping("/createquiz")
	public String createQuiz(@Valid QuizForm createQuizForm, BindingResult bindingResult, Principal principal) throws Exception {
		
		if(bindingResult.hasErrors()) {
			return "CreateQuiz"; // 에러가 있는 경우 반환할 뷰
		}
		
		Member m = this.ms.getUser(principal.getName());
		
		this.qs.create(createQuizForm.getCategory(),createQuizForm.getQuizLevel(),
				createQuizForm.getQuizTitle(), createQuizForm.getExplanation(), createQuizForm.getLimitation(),
				createQuizForm.getIoEx(), createQuizForm.getIoExplanation(), createQuizForm.getPresentCode(),
				createQuizForm.getSolutionCode(), createQuizForm.getQuizFile(),m
				);
		return "redirect:/quiz"; //퀴즈 생성 후 이동할 페이지
	}
	
//---------------퀴즈 리스트 페이지-----------------------------------------	

	@GetMapping(value = "/quiz") 
	public String quiz(Model model) {
        List<Quiz> quizList = this.qr.findAll();
        model.addAttribute("quizList", quizList);
                          //" "안에 있는 값이 html에서 인식할 텍스트
        return "quiz";  
	}

//---------------문제 풀기 페이지 주소 설정-----------------------------------------	
	
    @GetMapping(value = "/quiz/solve/{id}") 
    public String quizsolve(Model model, @PathVariable("id") Integer id) {
    	//문제 아이디로 조회해서 가져오기
    	Quiz q = this.qs.getQuiz(id);
        model.addAttribute("q", q);
        return "quizSolve";
    }


//---------------퀴즈의 질문 컨트롤-----------------------------------------

//	@GetMapping(value = "/quiz/solve/{id}") 
//	public String createquizqustion(Model model, @PathVariable("id") Integer id) {
//		//질문 작성한것 DB로 넘기기
//		this.qqr.createQuizQ(QuizQuestionForm.getQuizQuestionTitle(),
//						QuizQuestionForm.getQuizQuestionContent());
//		return "redirect:/quiz/solve/{id}";
//	}
//
//    같은주소 멀티맴핑이라고 에러나,,,,,,,,,
//	@GetMapping(value = "/quiz/solve/{id}") 
//	public String createquizqustion(@Valid QuizQuestionForm quizQuestionForm, BindingResult bindingResult) {
//		
//		if(bindingResult.hasErrors()) {
//			return "/quiz/solve/{id}"; // 에러가 있는 경우 반환할 뷰
//		}
//		
//		//Member m = this.ms.getUser(principal.getName());
//		
//		this.qs.createQuizQ(quizQuestionForm.getQuizQuestionTitle(),
//							quizQuestionForm.getQuizQuestionContent());
//		return "redirect:/quiz"; //퀴즈 생성 후 이동할 페이지
//	}
}
