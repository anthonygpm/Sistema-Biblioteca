package com.example.livros.dto.login;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank
        String email,

       @NotBlank
       String password
) {
}
