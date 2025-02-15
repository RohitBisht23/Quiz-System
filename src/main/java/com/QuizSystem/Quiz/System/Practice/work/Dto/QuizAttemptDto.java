package com.QuizSystem.Quiz.System.Practice.work.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizAttemptDto {

    private Long id;
    private Long userId;
    private Long quizId;
    private int totalScore;
    private String status;
    private List<QuizResponseDto> responses;
}
