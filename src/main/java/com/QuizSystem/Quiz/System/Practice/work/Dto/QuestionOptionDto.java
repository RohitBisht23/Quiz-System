package com.QuizSystem.Quiz.System.Practice.work.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOptionDto {
    private Long id;
    private String optionText;
    private boolean isCorrect;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
}
