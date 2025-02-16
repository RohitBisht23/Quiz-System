package com.QuizSystem.Quiz.System.Practice.work.Controller;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizResponseDto;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuizResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizResponse")
@RequiredArgsConstructor
public class QuizResponseController {

    private final QuizResponseService quizResponseService;

    @GetMapping("/getQuizResponseById/{quizId}")
    public ResponseEntity<QuizResponseDto> quizResponseById(@PathVariable Long quizId) {
        return ResponseEntity.ok(quizResponseService.getQuizResponseById(quizId));
    }

    @PostMapping("/create")
    public ResponseEntity<QuizResponseDto> createQuizResponse(@RequestBody QuizResponseDto quizResponseDto) {
        return ResponseEntity.ok(quizResponseService.createQuizResponse(quizResponseDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizResponseDto>> getAllQuizResponses() {
        return ResponseEntity.ok(quizResponseService.getAllQuizResponses());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<QuizResponseDto> updateQuizResponse(@PathVariable Long id, @RequestBody QuizResponseDto quizResponseDto) {
        return ResponseEntity.ok(quizResponseService.updateQuizResponse(id, quizResponseDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuizResponse(@PathVariable Long id) {
        quizResponseService.deleteQuizResponse(id);
        return ResponseEntity.ok("QuizResponse deleted successfully.");
    }
}
