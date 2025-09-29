package com.example.livros.dto.livro;

public record LivroResponseDTO(
        String titulo,
        String categoriaNome,
        String autorNome,
        Integer anoPublicacao
) {
}
