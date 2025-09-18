package com.example.livros.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class EmprestimoDTO {

    @NotBlank(message = "É obrigatório ter um livro para emprestar")
    private Long livroId;

    @NotBlank(message = "É obrigatório ter um usuário para emprestar")
    private Long usuarioId;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
