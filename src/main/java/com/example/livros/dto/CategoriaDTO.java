package com.example.livros.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    @NotBlank(message = "O nome da categoria não pode ser nulo")
    private String nome;
}
