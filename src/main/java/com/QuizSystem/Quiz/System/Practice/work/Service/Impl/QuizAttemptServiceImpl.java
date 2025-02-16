package com.QuizSystem.Quiz.System.Practice.work.Service.Impl;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizAttemptDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.QuizAttempt;
import com.QuizSystem.Quiz.System.Practice.work.Exception.ResourceNotFoundException;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuizAttemptRepository;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuizAttemptService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizAttemptServiceImpl implements QuizAttemptService {


    private final QuizAttemptRepository quizAttemptRepository;
    private final ModelMapper modelMapper;

    // Create QuizAttempt
    @Override
    public QuizAttemptDto createQuizAttempt(QuizAttemptDto quizAttemptDto) {
        QuizAttempt quizAttempt = modelMapper.map(quizAttemptDto, QuizAttempt.class);
        QuizAttempt savedAttempt = quizAttemptRepository.save(quizAttempt);
        return modelMapper.map(savedAttempt, QuizAttemptDto.class);
    }

    // Get QuizAttempt by ID
    @Override
    public QuizAttemptDto getQuizAttemptById(Long id) {
        QuizAttempt quizAttempt = quizAttemptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuizAttempt not found with ID: " + id));
        return modelMapper.map(quizAttempt, QuizAttemptDto.class);
    }

    // Get All QuizAttempts
    @Override
    public List<QuizAttemptDto> getAllQuizAttempts() {
        List<QuizAttempt> attempts = quizAttemptRepository.findAll();
        return attempts.stream()
                .map(attempt -> modelMapper.map(attempt, QuizAttemptDto.class))
                .collect(Collectors.toList());
    }

    // Update QuizAttempt
    @Override
    public QuizAttemptDto updateQuizAttempt(Long id, QuizAttemptDto quizAttemptDto) {
        QuizAttempt existingAttempt = quizAttemptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuizAttempt not found with ID: " + id));

        existingAttempt.setTotalScore(quizAttemptDto.getTotalScore());
        existingAttempt.setStatus(quizAttemptDto.getStatus().);

        QuizAttempt updatedAttempt = quizAttemptRepository.save(existingAttempt);
        return modelMapper.map(updatedAttempt, QuizAttemptDto.class);
    }

    // Delete QuizAttempt
    @Override
    public void deleteQuizAttempt(Long id) {
        QuizAttempt attempt = quizAttemptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuizAttempt not found with ID: " + id));
        quizAttemptRepository.delete(attempt);
    }
}
