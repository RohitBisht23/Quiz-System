package com.QuizSystem.Quiz.System.Practice.work.Service.Impl;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.Question;
import com.QuizSystem.Quiz.System.Practice.work.Entity.Quiz;
import com.QuizSystem.Quiz.System.Practice.work.Exception.ResourceNotFoundException;
import com.QuizSystem.Quiz.System.Practice.work.Exception.RunTimeConflictException;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuestionRepository;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuizRepository;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;
    private final ModelMapper mapper;
    private final QuizRepository quizRepository;


    @Override
    public QuestionDto createQuestion(QuestionDto newQuestion, Long quizId) {
        boolean isExist = repository.findByQuestionText(newQuestion.getQuestionText());
        if (isExist) {
            throw new RunTimeConflictException("Question already exists");
        }

        Question question = mapper.map(newQuestion, Question.class);

        // Assign quiz if quizId is provided
        if (quizId != null) {
            Quiz quiz = quizRepository.findById(quizId).orElseThrow(() ->
                    new ResourceNotFoundException("Quiz not found with ID: " + quizId));
            question.setQuiz(quiz);
        }

        Question savedQuestion = repository.save(question);
        return mapper.map(savedQuestion, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> allQuestionsList() {
        return repository.findAll().stream().map(question -> mapper.map(question, QuestionDto.class)).collect(Collectors.toList());
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        Question question = repository.findById(id).orElse(null);

        if(question == null) {
            throw new ResourceNotFoundException("No resources are found in the db with id :"+id);
        }

        return mapper.map(question, QuestionDto.class);
    }

    @Override
    public void deleteQuestionById(Long id) {
        Question question = repository.findById(id).orElse(null);

        if(question == null) {
            throw new ResourceNotFoundException("No resources are found in the db with id :"+id);
        }

        repository.deleteById(id);
    }
}
