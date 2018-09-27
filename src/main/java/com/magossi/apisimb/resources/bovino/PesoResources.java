package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Peso;
import com.magossi.apisimb.service.bovino.PesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/peso")
public class PesoResources {

    @Autowired
    public PesoService pesoService;



    // ******************************** METODOS PUT *******************************************************

    @RequestMapping(method =  RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Peso peso){
        peso = pesoService.alterar(peso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(peso.getIdPeso()).toUri();

        return ResponseEntity.created(uri).build();
    }

    // ******************************** METODOS POST *******************************************************

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Peso peso){
        peso = pesoService.salvar(peso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(peso.getIdPeso()).toUri();

        return ResponseEntity.created(uri).build();
    }

    // ******************************** METODOS DELETE *******************************************************

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id")Long id){

        pesoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // ******************************** METODOS GET *******************************************************


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Peso>> listar(){

        List<Peso> pesos = pesoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(pesos);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Peso> buscarPesoPorId(@PathVariable("id") Long id){   //? encapsula qualquer tipo de objeto

        Peso peso = pesoService.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(peso);
    }
}
