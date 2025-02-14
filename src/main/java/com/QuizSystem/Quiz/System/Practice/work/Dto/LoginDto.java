package com.QuizSystem.Quiz.System.Practice.work.Dto;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {

    private Long id;

    @Email(message = "Email must me correct and unique")
    private String email;
    private String name;
    private String password;
}
