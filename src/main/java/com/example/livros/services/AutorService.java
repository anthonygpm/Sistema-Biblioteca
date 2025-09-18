package com.example.livros.services;

import com.example.livros.model.Autor;
import com.example.livros.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id){
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não pode ser encontrado por id: " + id));
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor atualizar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletarPorId(Long id) {
        autorRepository.deleteById(id);
    }
}
