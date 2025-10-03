package com.Ouiz.QuizApplication.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddQuestionDTO {
	  private Long questionId;
	  private String question;
	  private List<OptionDTO> options;	  
}
