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
public class SubmitQuizRequestDTO {
    private Long quizId;
    private List<SubmitAnswerDTO> answers;
}
