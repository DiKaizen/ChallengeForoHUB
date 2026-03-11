package com.franco.ForoHUB.domain.topico;

import com.franco.ForoHUB.domain.usuario.DatosLoginUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record DatosTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @Valid DatosLoginUsuario usuario,
        @NotBlank String curso
) {
}
