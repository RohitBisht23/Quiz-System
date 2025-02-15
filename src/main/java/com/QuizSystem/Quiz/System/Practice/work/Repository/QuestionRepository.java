package com.QuizSystem.Quiz.System.Practice.work.Repository;

import com.QuizSystem.Quiz.System.Practice.work.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    boolean findByQuestionText(String questionText);
}
