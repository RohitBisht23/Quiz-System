package com.QuizSystem.Quiz.System.Practice.work.Service;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizResponseDto;

import java.util.List;

public interface QuizResponseService {
    QuizResponseDto getQuizResponseById(Long quizResponse);

    void deleteQuizResponse(Long id);

    QuizResponseDto updateQuizResponse(Long id, QuizResponseDto quizResponseDto);

    List<QuizResponseDto> getAllQuizResponses();

    QuizResponseDto createQuizResponse(QuizResponseDto quizResponseDto);
}
