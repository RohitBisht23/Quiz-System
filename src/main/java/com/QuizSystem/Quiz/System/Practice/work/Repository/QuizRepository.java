package com.QuizSystem.Quiz.System.Practice.work.Repository;

import com.QuizSystem.Quiz.System.Practice.work.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    boolean findByQuestionText(String questionText);
}
