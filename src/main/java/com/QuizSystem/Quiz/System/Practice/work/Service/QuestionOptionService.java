package com.QuizSystem.Quiz.System.Practice.work.Service;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionOptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionOptionService {
    QuestionOptionDto getOptionById(Long id);

    QuestionOptionDto createOption(QuestionOptionDto optionDto);

    List<QuestionOptionDto> getAllOptions();

    QuestionOptionDto updateOption(Long id, QuestionOptionDto optionDto);

    void deleteOption(Long id);
}
