package com.franco.ForoHUB.domain.topico;

import com.franco.ForoHUB.domain.usuario.DatosLoginUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record ActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso) {

}
