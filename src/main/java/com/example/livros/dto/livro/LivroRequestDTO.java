package com.example.livros.dto.livro;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(
        @NotBlank(message = "O título não pode ser vazio")
        String titulo,

        @NotNull(message = "O livro precisa ter uma categoria")
        Long categoriaId,

        @NotNull(message = "O livro precisa ter um autor")
        Long autorId,

        @Min(value = 1500, message = "Ano de publicação inválido")
        @Max(value = 2025, message = "Ano de publicação inválido")
        Integer anoPublicacao
) {
}
