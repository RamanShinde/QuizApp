package com.Ouiz.QuizApplication.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long quizId;
	  private String quizName;
	  @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
	  List<Question> questions=new ArrayList<Question>();
}
