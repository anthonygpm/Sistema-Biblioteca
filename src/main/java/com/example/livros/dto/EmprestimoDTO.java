package com.example.livros.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoDTO {

    @NotBlank(message = "É obrigatório ter um livro para emprestar")
    private Long livroId;

    @NotBlank(message = "É obrigatório ter um usuário para emprestar")
    private Long usuarioId;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;
}
