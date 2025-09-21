package com.example.livros.controller;

import com.example.livros.dto.RegistroDTO;
import com.example.livros.dto.login.LoginDTO;
import com.example.livros.dto.login.LoginResponseDTO;
import com.example.livros.model.Usuario;
import com.example.livros.repository.UsuarioRepository;
import com.example.livros.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO dto){
        var emailPassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var authentication = authenticationManager.authenticate(emailPassword);

        var token = tokenService.generateToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody @Valid RegistroDTO dto) {
        if (this.usuarioRepository.findByEmail(dto.getEmail()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), encryptedPassword, dto.getRole());

        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
