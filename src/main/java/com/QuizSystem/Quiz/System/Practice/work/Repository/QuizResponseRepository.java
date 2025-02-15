package com.QuizSystem.Quiz.System.Practice.work.Repository;

import com.QuizSystem.Quiz.System.Practice.work.Entity.QuizResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizResponseRepository extends JpaRepository<QuizResponse, Long> {
}
