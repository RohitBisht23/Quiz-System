package com.QuizSystem.Quiz.System.Practice.work.Controller;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuestionDto;
import com.QuizSystem.Quiz.System.Practice.work.Entity.Question;
import com.QuizSystem.Quiz.System.Practice.work.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService service;

    @PostMapping("CreateQuetion")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto question) {
        QuestionDto newQuestion = service.createQuestion(question);
        return new ResponseEntity<>(createQuestion(question), HttpStatus.CREATED);
    }

}
