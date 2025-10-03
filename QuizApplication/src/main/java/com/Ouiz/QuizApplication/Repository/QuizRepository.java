package com.Ouiz.QuizApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ouiz.QuizApplication.DTO.QuizDTO;
import com.Ouiz.QuizApplication.Entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {

	List<Quiz> findByquizNameContainingIgnoreCase(String quizName);
}
