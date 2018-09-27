package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.FichaMatriz;
import com.magossi.apisimb.service.matriz.FichaMatrizService;
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
@RequestMapping("/fichamatriz")
public class FichaMatrizResources {

    @Autowired
    public FichaMatrizService fichaMatrizService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody FichaMatriz fichaMatriz){
        fichaMatriz = fichaMatrizService.salvar(fichaMatriz);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fichaMatriz.getIdFichaMatriz()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FichaMatriz>> listar() {

        List<FichaMatriz> fichaMatrizes = fichaMatrizService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(fichaMatrizes);
    }


}
