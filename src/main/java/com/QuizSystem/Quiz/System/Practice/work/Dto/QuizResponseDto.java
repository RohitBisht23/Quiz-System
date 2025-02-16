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
    private Long id;               // Response ID
    private Long questionId;       // Associated Question
    private String selectedOption; // Chosen Answer
    private boolean correct;       // True if correct
    private int score;             // Points for this response
    private Long quizAttemptId;    // Associated Quiz Attempt
    private Long quizId;           // Optional: ID of the Quiz
}
