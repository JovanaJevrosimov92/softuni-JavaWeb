package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFormDTO {

        @NotBlank(message = "Username is required")
        @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
        private String username;

        @NotBlank(message = "Full name is required")
        @Size(min = 5, max = 20, message = "Full name must be between 5 and 20 characters")
        private String fullname;

        @NotBlank(message = "Email is required")
        @Email(message = "Must be a valid email")
        private String email;
//
        @NotNull(message = "Age is required")
        @Min(value = 0, message = "Age must be greater than or equal to 0")
        @Max(value = 90, message = "Age must be less than or equal to 90")
        private Integer age;

        @NotBlank(message = "Password is required")
        @Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters")
        private String password;

        @NotBlank(message = "Confirm password is required")
        private String confirmPassword;


    }


