package com.QuizSystem.Quiz.System.Practice.work.Controller;


import com.QuizSystem.Quiz.System.Practice.work.Dto.QuizDto;

import com.QuizSystem.Quiz.System.Practice.work.Service.QuizService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService service;


    @PostMapping("/createNewQuiz")
    public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto dto) {

        QuizDto quiz = service.createNewQuiz(dto);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    @GetMapping("/getQuiz")
    public ResponseEntity<List<QuizDto>> getAllQuiz() {
        List<QuizDto> list = service.getAllQuiz();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<QuizDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getQuizById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean isDeleted = service.deleteQuizById(id);

        if(isDeleted) {
            String deletedSuccess = "Quiz with id ${id} is deleted.";
            return new ResponseEntity<>(deletedSuccess, HttpStatus.OK);
        } else {
            String deleteFailure = "quiz is not deleted";
            return new ResponseEntity<>(deleteFailure, HttpStatus.OK);
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<QuizDto> updateById(@PathVariable Long id, @RequestBody QuizDto dto) {
        QuizDto quiz = service.updateQuizById(id, dto);

        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PatchMapping("/UpdateQuiz/{id}")
    public ResponseEntity<QuizDto> updateQuizPart(@PathVariable Long id, @RequestBody Map<String, Object> update) {
        return new ResponseEntity<>(service.updateQuizPartialById(id, update), HttpStatus.OK);
    }

}
