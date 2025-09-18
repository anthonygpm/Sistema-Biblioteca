package com.example.livros.services;

import com.example.livros.model.Categoria;
import com.example.livros.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) { this.categoriaRepository = categoriaRepository; }

    public List<Categoria> listarTodos(){ return categoriaRepository.findAll(); }

    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não pode ser encontrada por id: " + id));
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void deletarPorId(Long id) {
        categoriaRepository.deleteById(id);
    }
}
