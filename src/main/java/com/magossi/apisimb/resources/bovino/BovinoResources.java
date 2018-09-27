package com.magossi.apisimb.resources.bovino;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.magossi.apisimb.domain.bovino.Bovino;

import com.magossi.apisimb.domain.bovino.Desmama;
import com.magossi.apisimb.domain.bovino.Ecc;
import com.magossi.apisimb.domain.bovino.Peso;
import com.magossi.apisimb.domain.matriz.FichaMatriz;
import com.magossi.apisimb.domain.matriz.Inseminacao;
import com.magossi.apisimb.repository.bovino.DesmamaRepository;
import com.magossi.apisimb.service.bovino.BovinoService;
import com.magossi.apisimb.service.bovino.EccService;
import com.magossi.apisimb.gestao.GestaoRespositoryBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by RafaelMq on 15/05/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/bovino")
public class BovinoResources {


    @Autowired
    BovinoService bovinoService;

    @Autowired
    EccService eccService;

    @Autowired
    DesmamaRepository desmamaRepository;

    GestaoRespositoryBanco grb = new GestaoRespositoryBanco();


    // ******************************** METODOS PUT *******************************************************

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Bovino bovino) {

        bovino = grb.alterarBovino(bovino);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }

    // ******************************** METODOS POST *******************************************************

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Bovino bovino) {
        bovino = bovinoService.salvar(bovino);
        grb.alterarBovino(bovino.getIdBovino().intValue());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}/ecc", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarEccBovino(@PathVariable("id") Long id, @RequestBody Ecc ecc) {
        Bovino bovino = bovinoService.buscarId(id);
        bovino.getEcc().add(ecc);
        bovino = bovinoService.alterar(bovino);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/peso", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarPesoBovino(@PathVariable("id") Long id, @RequestBody Peso peso) {
        Bovino bovino = bovinoService.buscarId(id);

        bovino.getPeso().add(peso);
        bovino = bovinoService.alterar(bovino);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/fichamatriz", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarFichaMatrizBovino(@PathVariable("id") Long id, @RequestBody FichaMatriz fichaMatriz) {
        Bovino bovino = bovinoService.buscarId(id);

        bovino.setFichaMatriz(fichaMatriz);
        bovino = bovinoService.alterar(bovino);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/inseminacao", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarInseminacaoFichaMatriz(@PathVariable("id") Long id, @RequestBody Inseminacao inseminacao) {

        Bovino bovino = bovinoService.buscarId(id);

        if (bovino.getFichaMatriz().getInseminacao().isEmpty()) {
            List<Inseminacao> inseminacaos = new ArrayList<>();
            bovino.getFichaMatriz().setInseminacao(inseminacaos);
        }


        bovino.getFichaMatriz().getInseminacao().add(inseminacao);

        bovino = bovinoService.alterar(bovino);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();
    }


    // ******************************** METODOS GET *******************************************************

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> listar() {
 
        List<Bovino> bovino = bovinoService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(bovino);
    }

    @RequestMapping(value = "/ativos", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> listarAtivos() {

        List<Bovino> bovino = bovinoService.buscarTodosAtivos();
        return ResponseEntity.status(HttpStatus.OK).body(bovino);
    }

    @Scope("request")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces="text/plain; application/json", consumes="text/plain; application/json")
    public ResponseEntity<String> buscarBovinoPorId(@PathVariable("id") String id) throws JsonProcessingException {   //? encapsula qualquer tipo de objeto

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "text/json");
//        headers.add("Access-Control-Allow-Credentials", "true");
//
//        headers.add("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
//        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


        Bovino bovino = bovinoService.buscarId(Long.valueOf(id));


        String json = ow.writeValueAsString(bovino);

        return (new ResponseEntity<String>(json, headers, HttpStatus.OK));
//        return ResponseEntity.status(HttpStatus.OK).body(bovino);
    }

    @RequestMapping(value = "/tag/{tag}", method = RequestMethod.GET)
    public ResponseEntity<Bovino> buscarBovinoPorTag(@PathVariable("tag") String tag) {

        Bovino bovino = bovinoService.buscarTag(tag);
        return ResponseEntity.status(HttpStatus.OK).body(bovino);

    }

    @RequestMapping(value = "/nome/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> buscarBovinoPorNome(@PathVariable("busca") String busca, @PathVariable("tipoBusca") String tipoBusca) {
        List<Bovino> bovino = null;

        if ("todos".equals(busca)) {
            bovino = bovinoService.buscarTodosAtivos();
        } else if ("nome".equals(tipoBusca)) {
            bovino = bovinoService.buscarNomeBovino("%" + busca + "%");


        } else if ("raca".equals(tipoBusca)) {
            bovino = bovinoService.buscarPorRaca("%" + busca + "%");
        } else if ("fazenda".equals(tipoBusca)) {
            bovino = bovinoService.buscarPorFazenda("%" + busca + "%");
        } else if ("dataNascimento".equals(tipoBusca)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date data = formato.parse(busca);
                bovino = bovinoService.buscarPorData(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }


        return ResponseEntity.status(HttpStatus.OK).body(bovino);

    }

    @RequestMapping(value = "/mae/{mae}", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> buscarBovinoPorMae(@PathVariable("mae") String mae) {

        List<Bovino> bovino = bovinoService.buscarMae(mae);
        return ResponseEntity.status(HttpStatus.OK).body(bovino);

    }


    @RequestMapping(value = "/inseminada", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> buscarMatrizInseminada() {

        List<Bovino> bovino = bovinoService.buscarMatrizInseminada();
        List<Bovino> matrizs = new ArrayList<>();

        for (int i = 0; i < bovino.size(); i++) {

            if (bovino.get(i).getFichaMatriz().getInseminacao().size() > 0) {

                matrizs.add(bovino.get(i));
            }

        }
        Long maior = 0l;
        for (int i = 0; i < matrizs.size(); i++) {
            for (int j = 0; j < matrizs.get(i).getFichaMatriz().getInseminacao().size(); j++) {
                if (matrizs.get(i).getFichaMatriz().getInseminacao().get(j).getIdInseminacao() > maior) {
                    maior = matrizs.get(i).getFichaMatriz().getInseminacao().get(j).getIdInseminacao();
                }
            }
            for (int k = 0; k < matrizs.get(i).getFichaMatriz().getInseminacao().size(); k++) {
                matrizs.get(i).getFichaMatriz().getInseminacao().get(k).setIdInseminacao(maior);
            }
            maior = 0l;
        }

        return ResponseEntity.status(HttpStatus.OK).body(matrizs);

    }

    @RequestMapping(value = "/bezerro", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> buscarBezerro() {

        List<Bovino> bovino = bovinoService.buscarBezerro();


        List<Desmama> desmama = desmamaRepository.findAll();



        if (!(bovino.size() == desmama.size())) {
            for (int i = 0; i < bovino.size(); i++) {


                for (int j = 0; j < desmama.size(); j++) {

                    if (i < bovino.size()) {
                        if (bovino.get(i).getIdBovino() == desmama.get(j).getIdBovino()) {

                            bovino.remove(i);
                        }
                    }

                }
            }
        } else {
            bovino = new ArrayList<>();
        }


        return ResponseEntity.status(HttpStatus.OK).body(bovino);

    }


}
