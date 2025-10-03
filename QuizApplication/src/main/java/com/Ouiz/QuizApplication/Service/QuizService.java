package com.Ouiz.QuizApplication.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ouiz.QuizApplication.DTO.AddQuestionDTO;
import com.Ouiz.QuizApplication.DTO.CreateQuizRequestDTO;
import com.Ouiz.QuizApplication.DTO.OptionDTO;
import com.Ouiz.QuizApplication.DTO.QuestionDTO;
import com.Ouiz.QuizApplication.DTO.QuizDTO;
import com.Ouiz.QuizApplication.DTO.SubmitAnswerDTO;
import com.Ouiz.QuizApplication.DTO.SubmitQuizRequestDTO;
import com.Ouiz.QuizApplication.DTO.SubmitQuizResponseDTO;
import com.Ouiz.QuizApplication.Entity.OptionTable;
import com.Ouiz.QuizApplication.Entity.Question;
import com.Ouiz.QuizApplication.Entity.Quiz;
import com.Ouiz.QuizApplication.Repository.OptionRepository;
import com.Ouiz.QuizApplication.Repository.QuestionRepository;
import com.Ouiz.QuizApplication.Repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {
	@Autowired
	private OptionRepository optionRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private QuizRepository quizRepository;

	public QuizDTO createQuiz(CreateQuizRequestDTO createQuizRequestDTO) {
		Quiz quiz = Quiz.builder().quizName(createQuizRequestDTO.getQuizName()).build();
		Quiz quizSave = quizRepository.save(quiz);
		return mapToQuiz(quizSave);
	}

	private QuizDTO mapToQuiz(Quiz quiz) {
		return QuizDTO.builder().quizId(quiz.getQuizId()).quizName(quiz.getQuizName()).build();
	}

	public List<QuizDTO> getAllQuiz(String quizName) {
		List<Quiz> quizes = quizRepository.findByquizNameContainingIgnoreCase(quizName);
		return quizes.stream().map(q -> QuizDTO.builder().quizId(q.getQuizId()).quizName(q.getQuizName()).build())
				.collect(Collectors.toList());
	}

	public QuestionDTO addQuestion(Long quizId, AddQuestionDTO dto) {
		Quiz quiz=quizRepository.findById(quizId).orElseThrow(()-> new RuntimeException("User not found"));
		
		Question question=Question.builder()
				.question(dto.getQuestion())
				.quiz(quiz)
				.build();
		
		Question saveQuestioned=questionRepository.save(question);
		
		List<OptionTable> options = dto.getOptions().stream()
                .map(opt -> OptionTable.builder()
                        .text(opt.getText())
                        .correct(opt.isCorrect())
                        .question(question)
                        .build())
                .collect(Collectors.toList());
		 optionRepository.saveAll(options);
		 List<OptionDTO> ListOption=options.stream()
				 .map(opt->OptionDTO.builder()
						 .optionId(opt.getOptionId())
						 .text(opt.getText())
						 .correct(opt.isCorrect())
						 .build())
				 .collect(Collectors.toList());
		 
		return  QuestionDTO.builder()
				.questionId(saveQuestioned.getQuestionId())
				.question(saveQuestioned.getQuestion())
				.options(ListOption)
				.build();
	}
	  public SubmitQuizResponseDTO submitQuiz(SubmitQuizRequestDTO dto) {
	        int score = 0;
	        int total = dto.getAnswers().size();

	        for (SubmitAnswerDTO answer : dto.getAnswers()) {
	            OptionTable selected = optionRepository.findById(answer.getSelectedOptionId())
	                    .orElseThrow(() -> new RuntimeException("Option not found"));

	            if (selected.isCorrect()) {
	                score++;
	            }
	        }
	        return SubmitQuizResponseDTO.builder()
	                .score(score)
	                .total(total)
	                .build();
	    }

	public List<QuestionDTO> getQuestionsForQuiz(Long quizId) {
		Quiz quiz=quizRepository.findById(quizId).orElseThrow(()-> new RuntimeException("Quiz not found!!"));
		return null;
	}
}
