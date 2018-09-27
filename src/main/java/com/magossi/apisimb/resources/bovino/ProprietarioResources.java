package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Proprietario;
import com.magossi.apisimb.service.bovino.ProprietarioService;
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
@RequestMapping("/proprietario")
public class ProprietarioResources {

    @Autowired
    public ProprietarioService proprietarioService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Proprietario proprietario){
        proprietario = proprietarioService.salvar(proprietario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(proprietario.getIdProprietario()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Proprietario>> listar(){

        List<Proprietario> proprietarios = proprietarioService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(proprietarios);
    }
}
