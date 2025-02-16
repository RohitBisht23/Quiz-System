package com.QuizSystem.Quiz.System.Practice.work.Controller;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionOptionDto;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuestionOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionOptions")
@RequiredArgsConstructor
public class QuestionOptionController {

    private final QuestionOptionService questionOptionService;

    @GetMapping("/{id}")
    public ResponseEntity<QuestionOptionDto> getOptionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionOptionService.getOptionById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<QuestionOptionDto> createOption(@RequestBody QuestionOptionDto optionDto) {
        return ResponseEntity.ok(questionOptionService.createOption(optionDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionOptionDto>> getAllOptions() {
        return ResponseEntity.ok(questionOptionService.getAllOptions());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<QuestionOptionDto> updateOption(@PathVariable Long id, @RequestBody QuestionOptionDto optionDto) {
        return ResponseEntity.ok(questionOptionService.updateOption(id, optionDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOption(@PathVariable Long id) {
        questionOptionService.deleteOption(id);
        return ResponseEntity.ok("Question option deleted successfully.");
    }
}
