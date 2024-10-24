package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
    public class LoginFormDTO {

        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
        private String username;

        @NotBlank(message = "Password is required")
        @Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
        private String password;


    }


