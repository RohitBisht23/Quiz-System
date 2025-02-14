package com.QuizSystem.Quiz.System.Practice.work.Advice;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}