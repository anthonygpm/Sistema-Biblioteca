package com.example.livros.dto.usuario;

import com.example.livros.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String username,

        @NotBlank(message = "O email é obrigatório")
        @Email
        String email,

        @NotBlank(message = "A senha é obrigatória")
        String password,

        @NotNull(message = "O role é obrigatório e deve ser igual a ADMIN | EMPLOYEE | USER")
        UserRole role
) {
}
