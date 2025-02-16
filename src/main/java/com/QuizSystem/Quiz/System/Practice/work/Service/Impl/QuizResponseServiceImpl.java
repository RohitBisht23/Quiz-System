package com.QuizSystem.Quiz.System.Practice.work.Service.Impl;


import aj.org.objectweb.asm.commons.Remapper;
import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizDto;
import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizResponseDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.Quiz;
import com.QuizSystem.Quiz.System.Practice.work.Entity.QuizResponse;
import com.QuizSystem.Quiz.System.Practice.work.Exception.ResourceNotFoundException;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuizResponseRepository;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuizResponseService;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizResponseServiceImpl implements QuizResponseService {

    private final QuizResponseRepository quizResponseRepository;
    private final QuizService quizService;
    private final ModelMapper mapper;


    // Create QuizResponse
    @Override
    public QuizResponseDto createQuizResponse(QuizResponseDto quizResponseDto) {
        QuizResponse quizResponse = mapper.map(quizResponseDto, QuizResponse.class);
        QuizResponse savedResponse = quizResponseRepository.save(quizResponse);
        return mapper.map(savedResponse, QuizResponseDto.class);
    }

    // Get QuizResponse by ID
    @Override
    public QuizResponseDto getQuizResponseById(Long id) {
        QuizResponse quizResponse = quizResponseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuizResponse not found with ID: " + id));
        return mapper.map(quizResponse, QuizResponseDto.class);
    }

    // Get All QuizResponses
    @Override
    public List<QuizResponseDto> getAllQuizResponses() {
        List<QuizResponse> responses = quizResponseRepository.findAll();
        return responses.stream()
                .map(response -> mapper.map(response, QuizResponseDto.class))
                .collect(Collectors.toList());
    }

    // Update QuizResponse
    @Override
    public QuizResponseDto updateQuizResponse(Long id, QuizResponseDto quizResponseDto) {
        QuizResponse existingResponse = quizResponseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuizResponse not found with ID: " + id));

        existingResponse.setSelectedOption(quizResponseDto.getSelectedOption());
        existingResponse.setCorrect(quizResponseDto.isCorrect());
        existingResponse.setScore(quizResponseDto.getScore());

        QuizResponse updatedResponse = quizResponseRepository.save(existingResponse);

        return mapper.map(updatedResponse, QuizResponseDto.class);
    }

    // Delete QuizResponse
    @Override
    public void deleteQuizResponse(Long id) {
        QuizResponse response = quizResponseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuizResponse not found with ID: " + id));
        quizResponseRepository.delete(response);
    }
}
