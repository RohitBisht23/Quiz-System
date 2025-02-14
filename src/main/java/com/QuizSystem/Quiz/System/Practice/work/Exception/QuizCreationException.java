package com.QuizSystem.Quiz.System.Practice.work.Exception;

public class QuizCreationException extends RuntimeException {
    public QuizCreationException(String message) {
        super(message);
    }

    public QuizCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
