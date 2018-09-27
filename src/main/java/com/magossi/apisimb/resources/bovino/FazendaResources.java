package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Fazenda;
import com.magossi.apisimb.service.bovino.FazendaService;
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
@RequestMapping("/fazenda")
public class FazendaResources {

    @Autowired
    public FazendaService fazendaService;


    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Fazenda fazenda){
        fazenda = fazendaService.salvar(fazenda);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fazenda.getIdFazenda()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Fazenda>> listar(){

        List<Fazenda> fazendas = fazendaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(fazendas);
    }
}
