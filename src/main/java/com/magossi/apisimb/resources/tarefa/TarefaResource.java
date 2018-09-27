package com.magossi.apisimb.resources.tarefa;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.matriz.Inseminacao;
import com.magossi.apisimb.domain.tarefa.Tarefa;
import com.magossi.apisimb.gestao.GestaoRespositoryBanco;
import com.magossi.apisimb.service.bovino.BovinoService;
import com.magossi.apisimb.service.tarefa.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 16/11/2016.
 */

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/tarefa")
public class TarefaResource {

    @Autowired
    public TarefaService tarefaService;

    @Autowired
    public BovinoService bovinoService;

    GestaoRespositoryBanco gestaoRespositoryBanco = new GestaoRespositoryBanco();

    // ******************************** METODOS POST *******************************************************


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Tarefa tarefa) {
        tarefa = tarefaService.salvar(tarefa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefa.getIdTarefa()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/inseminacao", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarInseminacaoTarefa(@PathVariable("id") Long id, @RequestBody Inseminacao inseminacao) {
        Tarefa tarefa = tarefaService.buscarId(id);



        if (tarefa.getBovinoMatriz().getFichaMatriz().getInseminacao().isEmpty()) {
            List<Inseminacao> inseminacaos = new ArrayList<>();
            tarefa.getBovinoMatriz().getFichaMatriz().setInseminacao(inseminacaos);
        }

        tarefa.setStatusDaTarefa(true);
        tarefa.setDataConclusao(new Date());
        if(inseminacao.getPrevisaoParto()==null){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 285);
            inseminacao.setPrevisaoParto(cal.getTime());
        }
        tarefa.getBovinoMatriz().getFichaMatriz().getInseminacao().add(inseminacao);
        tarefa = tarefaService.atualizar(tarefa);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefa.getIdTarefa()).toUri();

        return ResponseEntity.created(uri).build();
    }


    // ******************************** METODOS PUT *******************************************************

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Tarefa tarefa) {
        tarefa = tarefaService.alterar(tarefa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefa.getIdTarefa()).toUri();

        return ResponseEntity.created(uri).build();
    }


    // ******************************** METODOS DELETE *******************************************************

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

        tarefaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }


    // ******************************** METODOS GET *******************************************************

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> listar() {

        List<Tarefa> tarefas = tarefaService.buscarTodas();
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);
    }

    @RequestMapping(value = "/ativas", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> listarAtivas() {

        List<Tarefa> tarefas = tarefaService.buscarTodasAtivas();
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);
    }

    @RequestMapping(value = "/concluidas", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> listarConcluidas() {

        List<Tarefa> tarefas = tarefaService.buscarTodasConcluidas();
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);
    }

    @RequestMapping(value = "/imei/{imei}", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> buscarTarefaPorImei(@PathVariable("imei") String imei) {

        List<Tarefa> tarefas = tarefaService.buscarImei(imei);
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable("id") Long id) {   //? encapsula qualquer tipo de objeto

        Tarefa tarefa = tarefaService.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }

    @RequestMapping(value = "/bovinoMatriz/{idBovino}", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> buscarTarefasPorBovinoMatriz(@PathVariable("idBovino") Long idBovino) {
        Bovino bovino = bovinoService.buscarId(idBovino);
        List<Tarefa> tarefas = tarefaService.buscarPorBovinoMatriz(bovino);
        return ResponseEntity.status(HttpStatus.OK).body(tarefas);

    }

    @RequestMapping(value = "/dataAtivas/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> buscarTarefaAtivasPorData(@PathVariable("busca") String busca, @PathVariable("tipoBusca") String tipoBusca) throws Exception {

        List<Tarefa> tarefas = null;

        if ("todos".equals(busca)) {
            tarefas = tarefaService.buscarTodasAtivas();
        } else if ("nome".equals(tipoBusca)) {
            tarefas = tarefaService.buscarPorBovino("%"+busca, false);
        } else if ("tipoTarefa".equals(tipoBusca)) {
            tarefas = tarefaService.buscarPorTipoTarefa(busca, false);
        } else if ("funcionario".equals(tipoBusca)) {
            tarefas = tarefaService.buscarPorFuncionario(busca, false);
        } else if ("dataInclusao".equals(tipoBusca)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                tarefas = tarefaService.buscarPorData(data1, data2, false);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }


        return ResponseEntity.status(HttpStatus.OK).body(tarefas);

    }


    @RequestMapping(value = "/dataConcluidas/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Tarefa>> buscarTarefaConcluidasPorData(@PathVariable("busca") String busca, @PathVariable("tipoBusca") String tipoBusca) throws Exception {

        List<Tarefa> tarefas = null;

        if ("todos".equals(busca)) {
            tarefas = tarefaService.buscarTodasConcluidas();
        } else if ("nome".equals(tipoBusca)) {

            tarefas = tarefaService.buscarPorBovino("%"+busca, true);
        } else if ("tipoTarefa".equals(tipoBusca)) {
            tarefas = tarefaService.buscarPorTipoTarefa(busca, true);
        } else if ("funcionario".equals(tipoBusca)) {
            tarefas = tarefaService.buscarPorFuncionario(busca, true);
        } else if ("dataExecucao".equals(tipoBusca)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);
                tarefas = tarefaService.buscarPorData(data1, data2, true);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }


        return ResponseEntity.status(HttpStatus.OK).body(tarefas);

    }


}
