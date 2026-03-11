package com.franco.ForoHUB.domain.topico;

import com.franco.ForoHUB.domain.usuario.DatosUsuario;
import java.time.LocalDateTime;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        DatosUsuario usuario,
        String curso
) {
    public DatosListaTopicos(Topico topico) {
        this (
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                new DatosUsuario(topico.getUsuario()),
                topico.getCurso()
        );
    }
}
