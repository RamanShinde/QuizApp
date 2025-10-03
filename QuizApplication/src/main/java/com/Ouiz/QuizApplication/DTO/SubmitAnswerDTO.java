package com.Ouiz.QuizApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmitAnswerDTO {
    private Long questionId;
    private Long selectedOptionId;

}
