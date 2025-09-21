package com.example.livros.dto;

import com.example.livros.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    @NotBlank(message = "O username é obrigatório")
    private String username;

    @NotBlank(message = "O email é obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "O role é obrigatório")
    private String role;

    public UsuarioDTO(Usuario u) {
    }
}
