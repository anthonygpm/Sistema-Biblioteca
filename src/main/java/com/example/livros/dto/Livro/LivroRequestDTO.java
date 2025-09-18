package com.example.livros.dto.Livro;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LivroRequestDTO {

    @NotBlank(message = "O título não pode ser vazio")
    private String titulo;

    @NotNull(message = "O livro precisa ter uma categoria")
    private Long categoriaId;

    @NotNull(message = "O livro precisa ter um autor")
    private Long autorId;

    @Min(value = 1500, message = "Ano de publicação inválido")
    @Max(value = 2025, message = "Ano de publicação inválido")
    private Integer anoPublicacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
