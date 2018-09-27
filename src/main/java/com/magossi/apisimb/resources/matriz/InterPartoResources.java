package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.IntervaloParto;
import com.magossi.apisimb.service.matriz.InterPartoService;
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
@RequestMapping("/interparto")
public class InterPartoResources {

    @Autowired
    public InterPartoService interPartoService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody IntervaloParto intervaloParto){
        intervaloParto = interPartoService.salvar(intervaloParto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(intervaloParto.getIdIntervaloParto()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<IntervaloParto>> listar(){

        List<IntervaloParto> intervalosParto = interPartoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(intervalosParto);
    }
}
