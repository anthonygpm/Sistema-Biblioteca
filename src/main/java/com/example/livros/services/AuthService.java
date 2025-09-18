package com.example.livros.services;

import com.example.livros.dto.RegistroDTO;
import com.example.livros.dto.login.LoginDTO;
import com.example.livros.model.Role;
import com.example.livros.model.Usuario;
import com.example.livros.repository.UsuarioRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String autenticarEgerarToken(LoginDTO dto) {
        Usuario u = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));


        if (!passwordEncoder.matches(dto.getPassword(), u.getPassword())) {
            throw new BadCredentialsException("Senha inválida");
        }


        return jwtService.gerarToken(u);
    }

    public Usuario registrar(RegistroDTO dto) {
        Usuario user = new Usuario();
        user.setUsername(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        return usuarioRepository.save(user);
    }
}
