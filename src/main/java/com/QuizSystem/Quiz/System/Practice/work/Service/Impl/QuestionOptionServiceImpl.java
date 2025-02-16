package com.QuizSystem.Quiz.System.Practice.work.Service.Impl;

import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionOptionDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.QuestionOptions;
import com.QuizSystem.Quiz.System.Practice.work.Exception.ResourceNotFoundException;
import com.QuizSystem.Quiz.System.Practice.work.Repository.QuestionOptionsRepository;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuestionOptionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuestionOptionServiceImpl implements QuestionOptionService {

    private final QuestionOptionsRepository questionOptionRepository;
    private final ModelMapper modelMapper;

    @Override
    public QuestionOptionDto getOptionById(Long id) {
        QuestionOptions option = questionOptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionOption not found with ID: " + id));
        return modelMapper.map(option, QuestionOptionDto.class);
    }

    @Override
    public QuestionOptionDto createOption(QuestionOptionDto optionDto) {
        QuestionOptions option = modelMapper.map(optionDto, QuestionOptions.class);
        QuestionOptions savedOption = questionOptionRepository.save(option);
        return modelMapper.map(savedOption, QuestionOptionDto.class);
    }

    @Override
    public List<QuestionOptionDto> getAllOptions() {
        List<QuestionOptions> options = questionOptionRepository.findAll();
        return options.stream()
                .map(option -> modelMapper.map(option, QuestionOptionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionOptionDto updateOption(Long id, QuestionOptionDto optionDto) {
        QuestionOptions existingOption = questionOptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionOption not found with ID: " + id));

        existingOption.setOptionText(optionDto.getOptionText());
        existingOption.setCorrect(optionDto.isCorrect());

        QuestionOptions updatedOption = questionOptionRepository.save(existingOption);
        return modelMapper.map(updatedOption, QuestionOptionDto.class);
    }

    @Override
    public void deleteOption(Long id) {
        QuestionOptions option = questionOptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionOption not found with ID: " + id));
        questionOptionRepository.delete(option);
    }
}