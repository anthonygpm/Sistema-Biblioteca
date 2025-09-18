package com.example.livros.controller;

import com.example.livros.dto.RegistroDTO;
import com.example.livros.dto.login.LoginDTO;
import com.example.livros.dto.login.TokenResponseDTO;
import com.example.livros.model.Usuario;
import com.example.livros.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginDTO dto){
        String token = authService.autenticarEgerarToken(dto);
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody @Valid RegistroDTO dto) {
        Usuario user = authService.registrar(dto);
        return ResponseEntity.ok(user);
    }
}
