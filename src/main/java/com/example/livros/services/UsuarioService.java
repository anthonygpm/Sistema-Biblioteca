package com.example.livros.services;

import com.example.livros.model.Usuario;
import com.example.livros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
