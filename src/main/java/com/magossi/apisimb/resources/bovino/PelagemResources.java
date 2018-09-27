package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Pelagem;
import com.magossi.apisimb.service.bovino.PelagemService;
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
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/pelagem")
public class PelagemResources {

    @Autowired
    public PelagemService pelagemService;


    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Pelagem pelagem){
        pelagem = pelagemService.salvar(pelagem);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pelagem.getIdPelagem()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pelagem>> listar(){

        List<Pelagem> pelagems = pelagemService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(pelagems);
    }
}
