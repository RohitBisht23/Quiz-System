package com.QuizSystem.Quiz.System.Practice.work.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDto {
    private Long id;
    private Long quizAttemptId;
    private Long questionId;
    private String selectedOption;
    private boolean isCorrect;
    private int score;
}
