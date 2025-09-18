package com.example.livros.dto.Livro;

public class LivroResponseDTO {

    private String titulo;

    private String categoriaNome;

    private String autorNome;

    private Integer anoPublicacao;

    public LivroResponseDTO(String titulo, String categoriaNome, String autorNome, Integer anoPublicacao) {
        this.titulo = titulo;
        this.categoriaNome = categoriaNome;
        this.autorNome = autorNome;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
