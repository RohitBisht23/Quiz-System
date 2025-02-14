package com.QuizSystem.Quiz.System.Practice.work.Service.Impl;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.Quiz;
import com.QuizSystem.Quiz.System.Practice.work.Exception.ResourceNotFoundException;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuizRepository;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;
    private final ModelMapper mapper;

    @Override
    public QuizDto createNewQuiz(QuizDto dto) {

        Quiz quiz = mapper.map(dto, Quiz.class);

        Quiz savedQuiz = repository.save(quiz);

        return mapper.map(savedQuiz, QuizDto.class);
    }

    @Override
    public List<QuizDto> getAllQuiz() {
        List<QuizDto> list = repository.findAll().stream().map(dto -> mapper.map(dto, QuizDto.class)).collect(Collectors.toList());

        if(list.isEmpty()) {
            throw new ResourceNotFoundException("No resouces are found in the db");
        }
        return list;
    }

    @Override
    public QuizDto getQuizById(Long id) {
        Quiz quiz = repository.findById(id).orElse(null);

        if(quiz == null) {
            throw new ResourceNotFoundException("No resouces are found in the db with id :"+id);
        }

        return mapper.map(quiz, QuizDto.class);
    }

    @Override
    public QuizDto updateQuizById(Long id, QuizDto dto) {
        Quiz quiz = repository.findById(id).orElse(null);

        if(quiz == null) {
            throw new ResourceNotFoundException("No resouces are found in the db with id :"+id);
        }

        Quiz updateQuiz = mapper.map(dto, Quiz.class);
        updateQuiz.setId(id);

        Quiz savedQuiz = repository.save(updateQuiz);
        return mapper.map(savedQuiz, QuizDto.class);
    }

    @Override
    public boolean deleteQuizById(Long id) {
        Quiz quiz = repository.findById(id).orElse(null);

        if(quiz == null) {
            throw new ResourceNotFoundException("No resouces are found in the db with id :"+id);
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public QuizDto updateQuizPartialById(Long id, Map<String, Object> update) {
        Quiz quiz = repository.findById(id).orElse(null);

        if(quiz == null) {
            throw new ResourceNotFoundException("No resouces are found in the db with id :"+id);
        }

        update.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(Quiz.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, quiz, value);
        });

        Quiz employeeEntityToBeSaved = repository.save(quiz);
        return mapper.map(employeeEntityToBeSaved, QuizDto.class);
    }


}
