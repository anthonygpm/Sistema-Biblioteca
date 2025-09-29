package com.example.livros.dto.autor;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AutorRequestDTO (
        @NotBlank(message = "O autor deve ter um nome")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nome,

        String nacionalidade,

        @Column(length = 1000)
        String biografia
) {
}
