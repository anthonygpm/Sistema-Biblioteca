package com.example.livros.dto.usuario;

import com.example.livros.model.UserRole;

public record UsuarioResponseDTO(
        Long id,
        String username,
        String email,
        UserRole role
) {
}
