package com.QuizSystem.Quiz.System.Practice.work.Service.Impl;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.Question;
import com.QuizSystem.Quiz.System.Practice.work.Exception.RunTimeConflictException;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuizRepository;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuizRepository repository;
    private final ModelMapper mapper;

    @Override
    public QuestionDto createQuestion(QuestionDto question) {
        boolean isExist = repository.findByQuestionText(question.getQuestionText());

        if(isExist) {
            throw new RunTimeConflictException("Question already exist");
        }

        Question ques = mapper.map(question, Question.class);

        Question savedQuestion = repository.save(ques);
    }
}
