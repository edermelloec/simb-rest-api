package com.magossi.apisimb.resources.matriz;

import com.magossi.apisimb.domain.matriz.Inseminacao;
import com.magossi.apisimb.service.matriz.InseminacaoService;
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
@RequestMapping("/inseminacao")
public class InseminacaoResources {


    @Autowired
    public InseminacaoService inseminacaoService;

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Inseminacao inseminacao){


        inseminacao = inseminacaoService.salvar(inseminacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(inseminacao.getIdInseminacao()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Inseminacao>> buscarPorId(@PathVariable("id") Long id) {

        List<Inseminacao> bovino = inseminacaoService.buscarPorId(id);
        if(bovino==null){
            bovino = new ArrayList<>();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bovino);

    }

    @RequestMapping(value = "/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Inseminacao>> listar(@PathVariable("busca")String busca, @PathVariable("tipoBusca")String tipoBusca){

        List<Inseminacao> inseminacoes=null;

        if("todos".equals(busca)){
            inseminacoes = inseminacaoService.listar();
        }else if ("nomeMatriz".equals(tipoBusca)){
            //inseminacoes = inseminacaoService.buscarPorMatriz("%"+busca+"%");
        }else if ("nomeTouro".equals(tipoBusca)){
            inseminacoes = inseminacaoService.buscarPorTouro("%"+busca+"%");
        }else if ("dataInseminacao".equals(tipoBusca)){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                inseminacoes = inseminacaoService.buscarPorDataInseminacao(data1,data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("dataPrevisaoParto".equals(tipoBusca)){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                inseminacoes = inseminacaoService.buscarPorDataPrevisaoParto(data1,data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("tipo".equals(tipoBusca)){
            inseminacoes = inseminacaoService.buscarPorTipo(busca);
        }else if ("funcionario".equals(tipoBusca)){
           // inseminacoes = inseminacaoService.buscarPorFuncionario(busca);
        }





        return ResponseEntity.status(HttpStatus.OK).body(inseminacoes);
    }
}

