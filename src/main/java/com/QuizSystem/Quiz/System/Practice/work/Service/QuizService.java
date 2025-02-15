package com.QuizSystem.Quiz.System.Practice.work.Service;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizDto;

import java.util.List;
import java.util.Map;

public interface QuizService {

    public QuizDto createNewQuiz(QuizDto dto);

    public List<QuizDto> getAllQuiz();

    QuizDto getQuizById(Long id);

    QuizDto updateQuizById(Long id, QuizDto dto);

    boolean deleteQuizById(Long id);

    QuizDto updateQuizPartialById(Long id, Map<String, Object> update);

    QuizDto assignQuestionToQuiz(Long questionId, Long quizId);
}
