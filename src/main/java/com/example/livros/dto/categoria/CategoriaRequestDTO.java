package com.example.livros.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO (
        @NotBlank(message = "O nome da categoria não pode ser nulo")
        String nome
) {
}
