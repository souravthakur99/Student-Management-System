package com.example.learningrestapi.studentdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;

@Data
public class CreatenewStudentdto {
    @NotBlank(message = "name is required")
    @Size(min=3,max=30,message = "min length 3 and max 30")
    private String name;
    @Email
    @NotBlank(message = "email required")
    private String email;
}
