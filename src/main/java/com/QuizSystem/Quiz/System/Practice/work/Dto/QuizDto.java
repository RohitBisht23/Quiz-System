package com.QuizSystem.Quiz.System.Practice.work.Dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuizDto {
    private Long id;

    @NotBlank(message = "The title cannot be empty")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @Positive(message = "Total score must be a positive number")
    private int totalScore;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Max(value = 180, message = "Duration cannot exceed 180 minutes")
    private int duration;
}
