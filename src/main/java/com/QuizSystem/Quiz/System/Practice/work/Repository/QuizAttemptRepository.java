package com.QuizSystem.Quiz.System.Practice.work.Repository;


import com.QuizSystem.Quiz.System.Practice.work.Entity.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
}
