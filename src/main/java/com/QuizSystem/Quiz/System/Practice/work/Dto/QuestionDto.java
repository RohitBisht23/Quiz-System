package com.QuizSystem.Quiz.System.Practice.work.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuestionDto {
    private Long id;
    private String questionText;
    private QuizDto quizId;

    private QuestionOptionDto options;
}
