package com.example.livros.dto.Livro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroResponseDTO {

    private String titulo;

    private String categoriaNome;

    private String autorNome;

    private Integer anoPublicacao;
}
