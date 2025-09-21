package com.example.livros.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorDTO {

    @NotBlank(message = "O autor deve ter um nome")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    private String nacionalidade;

    @Column(length = 1000)
    private String biografia;
}
