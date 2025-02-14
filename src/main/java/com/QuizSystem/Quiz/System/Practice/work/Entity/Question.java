package com.QuizSystem.Quiz.System.Practice.work.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question cannot be black")
    private String questionText;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "quiz_id", nullable = false)
//    private Quiz quiz;
}
