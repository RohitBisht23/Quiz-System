package com.QuizSystem.Quiz.System.Practice.work.Controller;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizAttemptDto;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuizAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @PostMapping("/create")
    public ResponseEntity<QuizAttemptDto> createQuizAttempt(@RequestBody QuizAttemptDto quizAttemptDto) {
        return ResponseEntity.ok(quizAttemptService.createQuizAttempt(quizAttemptDto));
    }

    @GetMapping("/getQuizAttemptById/{id}")
    public ResponseEntity<QuizAttemptDto> getQuizAttemptById(@PathVariable Long id) {
        return ResponseEntity.ok(quizAttemptService.getQuizAttemptById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizAttemptDto>> getAllQuizAttempts() {
        return ResponseEntity.ok(quizAttemptService.getAllQuizAttempts());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<QuizAttemptDto> updateQuizAttempt(@PathVariable Long id, @RequestBody QuizAttemptDto quizAttemptDto) {
        return ResponseEntity.ok(quizAttemptService.updateQuizAttempt(id, quizAttemptDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuizAttempt(@PathVariable Long id) {
        quizAttemptService.deleteQuizAttempt(id);
        return ResponseEntity.ok("QuizAttempt deleted successfully.");
    }
}
