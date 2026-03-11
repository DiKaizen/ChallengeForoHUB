package com.franco.ForoHUB.domain.usuario;

public record DatosUsuario(String login) {

    public DatosUsuario(Usuario usuario) {
        this(
                usuario.getLogin()
        );
    }
}
