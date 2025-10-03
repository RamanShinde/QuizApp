package com.Ouiz.QuizApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionTable {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long optionId;
	    private String text;
	    private boolean correct;
	    @ManyToOne
	    @JoinColumn(name = "question_id")
	    private Question question;
}
