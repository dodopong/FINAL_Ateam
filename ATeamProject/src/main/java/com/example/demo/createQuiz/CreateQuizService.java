package com.example.demo.createQuiz;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

//final 혹은 NotNull이 붙은 필드의 생성자를 자동으로 만들어 줌
@RequiredArgsConstructor
@Service
public class CreateQuizService { //강사가 업로드한 퀴즈 정보를 저장
	
	private final CreateQuizReposityory cqr;
	
	public void create(String category, Integer quizlevel, String quizTitle,
					   String explanation, String limitation, String ioEx,
					   String ioExplanation, String presentcode, String solutioncode,
					   String quizFile) {
		CreateQuiz cq = new CreateQuiz();
		cq.setCategory(category);
		cq.setQuizlevel(quizlevel);
		cq.setQuizTitle(quizTitle);
		cq.setExplanation(explanation);
		cq.setLimitation(limitation);
		cq.setIoEx(ioEx);
		cq.setIoExplanation(ioExplanation);
		cq.setPresentcode(presentcode);
		cq.setSolutioncode(solutioncode);
		cq.setQuizFile(quizFile);

		this.cqr.save(cq);
	}
	
	public CreateQuiz returnCreate
					(String category, Integer quizlevel, String quizTitle,
			   		 String explanation, String limitation, String ioEx,
			   		 String ioExplanation, String presentcode, String solutioncode,
			   		 String quizFile) {
		CreateQuiz cq = new CreateQuiz();
		cq.setCategory(category);
		cq.setQuizlevel(quizlevel);
		cq.setQuizTitle(quizTitle);
		cq.setExplanation(explanation);
		cq.setLimitation(limitation);
		cq.setIoEx(ioEx);
		cq.setIoExplanation(ioExplanation);
		cq.setPresentcode(presentcode);
		cq.setSolutioncode(solutioncode);
		cq.setQuizFile(quizFile);

		this.cqr.save(cq);
		return cq;
}	

}
