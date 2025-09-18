package com.example.livros.services;

import com.example.livros.model.Livro;
import com.example.livros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não pode ser encontrado pelo id: " + id));
    }

    public List<Livro> buscarPorCategoria(String categoriaNome){
        return livroRepository.findByCategoriaNome(categoriaNome);
    }

    public List<Livro> buscarPorAutor(String autorNome){
        return livroRepository.findByAutorNome(autorNome);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletarPorId(Long id) {
        livroRepository.deleteById(id);
    }
}
