package com.QuizSystem.Quiz.System.Practice.work.Dto;


import com.QuizSystem.Quiz.System.Practice.work.Enums.UserEnum;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    private Long id;

    private String firstName;
    private String secondName;

    @Column(unique = true)
    @Email(message = "Email must me correct and unique")
    private String email;
    private String password;
    private UserEnum role;
}
