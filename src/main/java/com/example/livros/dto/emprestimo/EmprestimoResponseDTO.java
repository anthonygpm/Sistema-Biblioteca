package com.example.livros.dto.emprestimo;

import java.time.LocalDate;

public record EmprestimoResponseDTO(
        Long livroId,
        Long usuarioId,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
) {
}
