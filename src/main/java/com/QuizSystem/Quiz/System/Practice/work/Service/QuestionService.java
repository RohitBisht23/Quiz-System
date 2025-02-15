package com.QuizSystem.Quiz.System.Practice.work.Service;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto createQuestion(QuestionDto question, Long quizId);

    List<QuestionDto> allQuestionsList();

    QuestionDto getQuestionById(Long id);

    void deleteQuestionById(Long id);
}
