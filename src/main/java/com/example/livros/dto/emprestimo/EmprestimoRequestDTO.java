package com.example.livros.dto.emprestimo;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record EmprestimoRequestDTO (
        @NotBlank(message = "É obrigatório ter um livro para emprestar")
        Long livroId,

        @NotBlank(message = "É obrigatório ter um usuário para emprestar")
        Long usuarioId,

        LocalDate dataEmprestimo,

        LocalDate dataDevolucao
) {
}
