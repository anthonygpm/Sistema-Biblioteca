package com.example.livros.repository;

import com.example.livros.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    public List<Emprestimo> findByUsuarioUsername(String usuarioNome);
    public List<Emprestimo> findByLivroTitulo(String livroNome);
}
