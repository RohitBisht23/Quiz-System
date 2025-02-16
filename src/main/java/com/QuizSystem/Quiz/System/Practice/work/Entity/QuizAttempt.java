package com.QuizSystem.Quiz.System.Practice.work.Entity;


import com.QuizSystem.Quiz.System.Practice.work.Entity.Enum.QuizAttempEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private int totalScore;
    private QuizAttempEnum status;

    @OneToMany(mappedBy = "quizAttempt", cascade = CascadeType.ALL)
    private List<QuizResponse> responses;
}
