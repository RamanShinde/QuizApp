package com.Ouiz.QuizApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ouiz.QuizApplication.DTO.AddQuestionDTO;
import com.Ouiz.QuizApplication.DTO.CreateQuizRequestDTO;
import com.Ouiz.QuizApplication.DTO.QuestionDTO;
import com.Ouiz.QuizApplication.DTO.QuizDTO;
import com.Ouiz.QuizApplication.DTO.SubmitQuizRequestDTO;
import com.Ouiz.QuizApplication.DTO.SubmitQuizResponseDTO;
import com.Ouiz.QuizApplication.Entity.Question;
import com.Ouiz.QuizApplication.Entity.Quiz;
import com.Ouiz.QuizApplication.Service.QuizService;

@RestController
@RequestMapping("api/Quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@GetMapping("/getMsg")
	public String GetMessage() {
		return "Welcome to Quiz App";
	}

	@PostMapping("/create")
	public ResponseEntity<QuizDTO> createQuiz(@RequestBody CreateQuizRequestDTO createQuizRequestDTO) {
		return ResponseEntity.ok(quizService.createQuiz(createQuizRequestDTO));
	}

	@GetMapping("/get/{quizName}")
	public ResponseEntity<List<QuizDTO>> getAllQuiz(@PathVariable String quizName) {
		return ResponseEntity.ok(quizService.getAllQuiz(quizName));
	}

	@PostMapping("/{quizId}/addQuestion")
	public ResponseEntity<QuestionDTO> addQuestion(@PathVariable Long quizId, @RequestBody AddQuestionDTO dto) {
		return ResponseEntity.ok(quizService.addQuestion(quizId, dto));
	}

	@PostMapping("/submit")
	public ResponseEntity<SubmitQuizResponseDTO> submitQuiz(@RequestBody SubmitQuizRequestDTO dto) {
		return ResponseEntity.ok(quizService.submitQuiz(dto));
	}
	
    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions(@PathVariable Long quizId) {
        return ResponseEntity.ok(quizService.getQuestionsForQuiz(quizId));
    }


}
