package com.example.demo.quiz;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

//final 혹은 NotNull이 붙은 필드의 생성자를 자동으로 만들어 줌
@RequiredArgsConstructor
@Service
public class QuizService { //강사가 업로드한 퀴즈 정보를 저장
	
	private final QuizRepository qr;
	private final QuizQuestionRepository qqr;

	
//---------------------	id값으로 퀴즈 데이터 조회---------------------  
    public Quiz getQuiz(Integer id) { 
        Optional<Quiz> q = this.qr.findById(id);
        if (q.isPresent()) {
            return q.get();
        } else {
            throw new DataNotFoundException("quiz not found");
            //만약 id값에 해당하는 질문 데이터가 없다면 DataNotFoundException 실행
        }
    }
    
   
//---------------------	강사가 업로드한 퀴즈 정보를 저장---------------------
	public void create(String category, String quizLevel, String quizTitle,
					   String explanation, String limitation, String ioEx,
					   String ioExplanation, String presentCode, String solutionCode,
					   String quizFile) {
		Quiz cq = new Quiz();
		cq.setCategory(category);
		cq.setQuizLevel(quizLevel);
		cq.setQuizTitle(quizTitle);
		cq.setExplanation(explanation);
		cq.setLimitation(limitation);
		cq.setIoEx(ioEx);
		cq.setIoExplanation(ioExplanation);
		cq.setPresentCode(presentCode);
		cq.setSolutionCode(solutionCode);
		cq.setQuizFile(quizFile);

		this.qr.save(cq);
	}
	
	public Quiz returnCreate
					(String category, String quizlevel, String quizTitle,
			   		 String explanation, String limitation, String ioEx,
			   		 String ioExplanation, String presentcode, String solutioncode,
			   		 String quizFile) {
		Quiz cq = new Quiz();
		cq.setCategory(category);
		cq.setQuizLevel(quizlevel);
		cq.setQuizTitle(quizTitle);
		cq.setExplanation(explanation);
		cq.setLimitation(limitation);
		cq.setIoEx(ioEx);
		cq.setIoExplanation(ioExplanation);
		cq.setPresentCode(presentcode);
		cq.setSolutionCode(solutioncode);
		cq.setQuizFile(quizFile);

		this.qr.save(cq);
		return cq;
}	

//---------------------	강사가 업로드한 퀴즈 정보를 저장---------------------
	public void createQuizQ(String quizQuestionTitle, String quizQuestionContent) {
		QuizQuestion qq = new QuizQuestion();
		qq.setQuizQuestionTitle(quizQuestionTitle);
		qq.setQuizQuestionContent(quizQuestionContent);

		this.qqr.save(qq);
	}	
	
	
	
	
}
