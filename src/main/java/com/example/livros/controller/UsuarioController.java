package com.example.livros.controller;

import com.example.livros.dto.UsuarioDTO;
import com.example.livros.model.Usuario;
import com.example.livros.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping
    public Usuario saveUsuario(@RequestBody @Valid UsuarioDTO dto) {
        return usuarioService.saveUsuario(dto);
    }
}

