package com.franco.ForoHUB.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosLoginUsuario(
        @NotBlank String login,
        @NotBlank String contrasena
) {
    public DatosLoginUsuario(Usuario usuario) {
        this(
                usuario.getLogin(),
                usuario.getContrasena()
        );
    }
}
