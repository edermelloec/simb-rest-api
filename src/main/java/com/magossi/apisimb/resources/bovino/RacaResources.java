package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Raca;
import com.magossi.apisimb.service.bovino.RacaService;
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
@RequestMapping("/raca")
public class RacaResources {

    @Autowired
    public RacaService racaService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Raca raca){
        raca = racaService.salvar(raca);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(raca.getIdRaca()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Raca>> listar(){

        List<Raca> racas = racaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(racas);
    }
}
