package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.Parto;
import com.magossi.apisimb.service.matriz.PartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/parto")
public class PartoResources {

    @Autowired
    PartoService partoService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Parto parto) {
        parto = partoService.salvar(parto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(parto.getIdParto()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Parto>> buscarBovinoPorMae(@PathVariable("id") Long id) {

        List<Parto> parto = partoService.buscarPorId(id);

        if(parto==null){
            parto = new ArrayList<>();
        }
        return ResponseEntity.status(HttpStatus.OK).body(parto);

    }
    @RequestMapping(value = "/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Parto>> listar(@PathVariable("busca")String busca, @PathVariable("tipoBusca")String tipoBusca){
        List<Parto> partos = null;
        if("todos".equals(busca)){
            partos = partoService.listar();
        }else if ("nomeMatriz".equals(tipoBusca)){
            partos = partoService.buscarPorMatriz("%"+busca+"%");
        }else if ("dataParto".equals(tipoBusca)){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                partos = partoService.buscarPorDataParto(data1,data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("descricao".equals(tipoBusca)){
            partos = partoService.buscarPorDescricao("%"+busca+"%");
        }else if ("status".equals(tipoBusca)){
            partos = partoService.buscarPorStatus("%"+busca+"%");
        }


        return ResponseEntity.status(HttpStatus.OK).body(partos);
    }

    @RequestMapping(value = "/salvar/parto", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarParto(@RequestBody Parto parto) {


        parto = partoService.salvarParto(parto);
        partoService.salvarQtdParto(parto.getIdFichaMatriz().intValue());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(parto.getIdParto()).toUri();

        return ResponseEntity.created(uri).build();

    }


}
