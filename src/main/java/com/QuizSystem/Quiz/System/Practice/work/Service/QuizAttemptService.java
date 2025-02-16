package com.QuizSystem.Quiz.System.Practice.work.Service;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizAttemptDto;

import java.util.List;

public interface QuizAttemptService {
    QuizAttemptDto createQuizAttempt(QuizAttemptDto quizAttemptDto);

    QuizAttemptDto getQuizAttemptById(Long id);

    List<QuizAttemptDto> getAllQuizAttempts();

    QuizAttemptDto updateQuizAttempt(Long id, QuizAttemptDto quizAttemptDto);

    void deleteQuizAttempt(Long id);
}
