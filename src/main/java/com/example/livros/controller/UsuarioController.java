package com.example.livros.controller;

import com.example.livros.dto.UsuarioDTO;
import com.example.livros.model.Usuario;
import com.example.livros.services.JwtService;
import com.example.livros.services.UsuarioService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public UsuarioController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.deletarPorId(id);
    }
}

