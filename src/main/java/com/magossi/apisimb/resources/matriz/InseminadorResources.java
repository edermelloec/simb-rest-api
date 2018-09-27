package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.Inseminador;
import com.magossi.apisimb.service.matriz.InseminadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/inseminador")
public class InseminadorResources {

    @Autowired
    public InseminadorService inseminadorService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Inseminador inseminador){
        inseminador = inseminadorService.salvar(inseminador);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(inseminador.getIdInseminador()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Inseminador>> listar(){

        List<Inseminador> inseminadores = inseminadorService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(inseminadores);
    }
}
