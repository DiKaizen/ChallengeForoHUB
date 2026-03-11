package com.franco.ForoHUB.domain.topico;

import com.franco.ForoHUB.domain.usuario.UsuarioRepository;
import com.franco.ForoHUB.infra.exceptions.ValidacionExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Topico verificarRegistro(DatosTopico datos){
        var topico = topicoRepository.findByTitulo(datos.titulo());
        if (topico.isPresent()){
            throw  new ValidacionExcepcion("Ya existe este titulo en el foro");
        }
        var usuario = usuarioRepository.findByLogin(datos.usuario().login());
        if (usuario.isEmpty()){
            throw new ValidacionExcepcion("No existe este usuario");
        }
        return new Topico(null,datos.titulo(), datos.mensaje(), LocalDateTime.now(),true,usuario.get(),datos.curso());
    }



}
