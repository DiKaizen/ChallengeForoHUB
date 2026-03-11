package com.franco.ForoHUB.controller;

import com.franco.ForoHUB.domain.topico.*;
import com.franco.ForoHUB.infra.exceptions.ValidacionExcepcion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    //INYECTANDO REPOSITORIO
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    //REGISTRAR TOPICO
    @Transactional
    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = topicoService.verificarRegistro(datos);

        topicoRepository.save(topico);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosListaTopicos(topico));
    }

    //MOSTRAR LISTA DE TOPICOS
    @GetMapping
    public ResponseEntity<List<DatosListaTopicos>> mostrarListaTopicos(){
        var lista = topicoRepository.findAllByActivoTrue().stream().map(DatosListaTopicos::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    //DETALLAR UN TOPICO
    @GetMapping("/{id}")
    public ResponseEntity<DatosListaTopicos> detallarTopico(@PathVariable Long id){
        var topico = topicoRepository.findById(id);
        if (!topico.isPresent()){
            throw new ValidacionExcepcion("No se encuentra este id en nuestro foro");
        }
        return ResponseEntity.ok(new DatosListaTopicos(topico.get()));
    }

    //ACTUALIZAR UN TOPICO
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id,@RequestBody @Valid ActualizarTopico datos) {
        var topico = topicoRepository.findById(id);
        if (!topico.isPresent()) {
            throw new ValidacionExcepcion("No se encuentra este id en nuestro foro");
        }
        topico.get().actualizarInformacion(datos);
        return ResponseEntity.ok(new DatosListaTopicos(topico.get()));
    }

    //ELIMINAR TOPICO
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var topico = topicoRepository.findById(id);
        if (!topico.isPresent()) {
            throw new ValidacionExcepcion("No se encuentra este id en nuestro foro");
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }













}
