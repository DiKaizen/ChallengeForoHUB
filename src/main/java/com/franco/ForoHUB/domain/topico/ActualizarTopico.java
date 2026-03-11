package com.franco.ForoHUB.domain.topico;
import jakarta.validation.constraints.NotBlank;

public record ActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso) {

}
