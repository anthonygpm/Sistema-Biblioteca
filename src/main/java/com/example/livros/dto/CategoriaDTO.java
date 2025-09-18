package com.example.livros.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank(message = "O nome da categoria não pode ser nulo")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
