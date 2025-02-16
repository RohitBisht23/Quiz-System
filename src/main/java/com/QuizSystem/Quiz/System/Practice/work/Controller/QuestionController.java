package com.QuizSystem.Quiz.System.Practice.work.Controller;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionDto;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService service;

    @PostMapping("/CreateQuestion")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto question, @PathVariable Long quizId) {
        QuestionDto newQuestion = service.createQuestion(question, quizId);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/allQuestionList")
    public ResponseEntity<List<QuestionDto>> allQuestionsList() {
        return new ResponseEntity<>(service.allQuestionsList(), HttpStatus.OK);
    }

    @GetMapping("/getQuestionById")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getQuestionById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteQuestionById")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Long id) {
        service.deleteQuestionById(id);
        String message = "Question is deleted with :"+id;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
