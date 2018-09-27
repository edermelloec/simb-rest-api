package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.Resultado;
import com.magossi.apisimb.service.matriz.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/resultado")
public class ResultadoResources {

    @Autowired
    public ResultadoService resultadoService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Resultado resultado){
        resultado = resultadoService.salvar(resultado);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(resultado.getIdResultado()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Resultado>> listar(@PathVariable("busca") String busca, @PathVariable("tipoBusca") String tipoBusca){
        List<Resultado> resultados=null;
        if ("todos".equals(busca)) {
            resultados = resultadoService.listar();
        } else if ("nomeMatriz".equals(tipoBusca)) {
            resultados = resultadoService.buscarPorMatriz("%"+busca+"%");
        }else if ("resultado".equals(tipoBusca)) {
            resultados = resultadoService.buscarPorResultado("%"+busca+"%");
        }

        return ResponseEntity.status(HttpStatus.OK).body(resultados);
    }

    @RequestMapping(value = "/inseminacao/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Resultado>> buscarPorInseminacao(@PathVariable("id") Long id){
        List<Resultado> resultados=resultadoService.buscarPorInseminacao(id);
        if(resultados==null  ) {
            resultados = new ArrayList<>();
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultados);
    }
}
