package com.magossi.apisimb.resources.gestao;

import com.magossi.apisimb.domain.bovino.*;
import com.magossi.apisimb.domain.matriz.FichaTouro;
import com.magossi.apisimb.repository.bovino.AbatidoRepository;
import com.magossi.apisimb.repository.bovino.VendaRepository;
import com.magossi.apisimb.repository.matriz.FichaToutroRepository;
import com.magossi.apisimb.service.gestao.GestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@RestController
@RequestMapping("/gestao")
public class GestaoResources {
    @Autowired
    GestaoService gestaoService;

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    AbatidoRepository abatidoRepository;

    @Autowired
    FichaToutroRepository fichaToutroRepository;

    @RequestMapping(value = "/listar/matriz", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> listarMatriz() {

        List<Bovino> matriz = gestaoService.listarMatriz();
        return ResponseEntity.status(HttpStatus.OK).body(matriz);
    }

    @RequestMapping(value = "/listar/vendidos", method = RequestMethod.GET)
    public ResponseEntity<List<Venda>> listarVenda() {

        List<Venda> venda = vendaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(venda);
    }
    @RequestMapping(value = "/listar/abatidos", method = RequestMethod.GET)
    public ResponseEntity<List<Abatido>> listarAbatidos() {

        List<Abatido> abatidos = abatidoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(abatidos);
    }



    @RequestMapping(value = "/nome/matriz/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bovino> buscarNomeMatriz(@PathVariable("id") Integer id) {

        Bovino bovino = gestaoService.buscaNomeMatriz(id);
        return ResponseEntity.status(HttpStatus.OK).body(bovino);
    }

    @RequestMapping(value = "/listar/touro", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> listarTouro() {

        List<Bovino> bovinos = gestaoService.listarTouro();

        List<FichaTouro> touros = fichaToutroRepository.findAll();



        int aux;
        if (!(bovinos.size() == touros.size())) {
            for (int i = 0; i < bovinos.size(); i++) {

                aux = i;
                for (int j = 0; j < touros.size(); j++) {

                    if (i < bovinos.size()) {
                        if (bovinos.get(i).getIdBovino() == touros.get(j).getIdBovino()) {

                            bovinos.remove(i);
                        }
                    }

                }
            }
        }else {
            bovinos = new ArrayList<>();
        }





        return ResponseEntity.status(HttpStatus.OK).body(bovinos);
    }


    @RequestMapping(value = "/listar/femea", method = RequestMethod.GET)
    public ResponseEntity<List<Bovino>> listarFemea() {

        List<Bovino> matriz = gestaoService.listarFemea();
        return ResponseEntity.status(HttpStatus.OK).body(matriz);
    }

    @RequestMapping(value = "/prenhez/todos", method = RequestMethod.GET)
    public ResponseEntity<String> prenhezTodos() {

        String json = gestaoService.prenhezTodos();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/prenhez/novilha", method = RequestMethod.GET)
    public ResponseEntity<String> prenhezNovilha() {

        String json = gestaoService.prenhezNovilha();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/prenhez/primi", method = RequestMethod.GET)
    public ResponseEntity<String> prenhezPrimi() {

        String json = gestaoService.prenhezPrimi();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/prenhez/mult", method = RequestMethod.GET)
    public ResponseEntity<String> prenhezMult() {

        String json = gestaoService.prenhezMult();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/natalidade/todos", method = RequestMethod.GET)
    public ResponseEntity<String> natalidadeTotal() {

        String json = gestaoService.natalidadeTotal();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/natalidade/novilha", method = RequestMethod.GET)
    public ResponseEntity<String> natalidadeNovilha() {

        String json = gestaoService.natalidadeNovilha();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/natalidade/primi", method = RequestMethod.GET)
    public ResponseEntity<String> natalidadePrimi() {

        String json = gestaoService.natalidadePrimi();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/natalidade/mult", method = RequestMethod.GET)
    public ResponseEntity<String> natalidadeMult() {

        String json = gestaoService.natalidadeMult();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/peso/desmama", method = RequestMethod.GET)
    public ResponseEntity<String> mediaPesoDesmama() {

        String json = gestaoService.mediaPesoDesmama();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/idade/desmama", method = RequestMethod.GET)
    public ResponseEntity<String> mediaIdadeDesmama() {

        String json = gestaoService.mediaIdadeDesmama();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/idade/{bovino}", method = RequestMethod.GET)
    public ResponseEntity<String> idadePrimeiraCria(@PathVariable("bovino") String bovino) {

        String json = gestaoService.idadePrimeiraCria(bovino);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/desmama/{bovino}", method = RequestMethod.GET)
    public ResponseEntity<String> idadeDesmama(@PathVariable("bovino") String bovino) {

        String json = gestaoService.idadeDesmama(bovino);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/mortalidade/todos", method = RequestMethod.GET)
    public ResponseEntity<String> mortalidadeTotal() {

        String json = gestaoService.mortalidadeTotal();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/mortalidade/preparto", method = RequestMethod.GET)
    public ResponseEntity<String> mortalidadePreParto() {

        String json = gestaoService.mortalidadePreParto();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/mortalidade/adulto", method = RequestMethod.GET)
    public ResponseEntity<String> mortalidadeAdulto() {

        String json = gestaoService.mortalidadeAdulto();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/mortalidade/jovens", method = RequestMethod.GET)
    public ResponseEntity<String> mortalideJovens() {

        String json = gestaoService.mortalideJovens();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/mortalidade/desmama", method = RequestMethod.GET)
    public ResponseEntity<String> mortalideAteDesmame() {

        String json = gestaoService.mortalideAteDesmama();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/desmama", method = RequestMethod.GET)
    public ResponseEntity<String> taxaDesmama() {

        String json = gestaoService.taxaDesmama();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/abate", method = RequestMethod.GET)
    public ResponseEntity<String> taxaAbate() {

        String json = gestaoService.taxaAbate();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }


    @RequestMapping(value = "/desfrute/{dataInicial}/{dataFinal}", method = RequestMethod.GET)
    public ResponseEntity<String> taxaDesfrute(@PathVariable("dataInicial") String dataInicial,@PathVariable("dataFinal") String dataFinal) {

        String json = gestaoService.taxaDesfrute(dataInicial,dataFinal);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/touroVaca", method = RequestMethod.GET)
    public ResponseEntity<String> taxaTouroVaca() {

        String json = gestaoService.touroVaca();
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @RequestMapping(value = "/salvar/vendido", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarVendido(@RequestBody Venda venda) {
        long id = gestaoService.salvarVendido(venda.getIdBovino());

        vendaRepository.save(venda);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/salvar/abatido", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarAbatido(@RequestBody Abatido abatido) {
        Long id = gestaoService.salvarAbatido(abatido.getIdBovino());
        abatidoRepository.save(abatido);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();

    }



    @RequestMapping(value = "/salvar/bovino", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarBovino(@RequestBody Bovino bovino) {
        bovino = gestaoService.salvarBovino(bovino);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bovino.getIdBovino()).toUri();

        return ResponseEntity.created(uri).build();

    }


    @RequestMapping(value = "/salvar/morte", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarMorte(@RequestBody Morto morto) {
        morto = gestaoService.salvarMorto(morto);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(morto.getIdMorte()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/salvar/desmama", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarDesmama(@RequestBody Desmama desmama) {

        desmama = gestaoService.salvarDesmama(desmama);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(desmama.getIdDesmama()).toUri();

        return ResponseEntity.created(uri).build();

    }


    @RequestMapping(value = "/salvar/touro", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarTouro(@RequestBody FichaTouro touro) {

        touro = gestaoService.salvarTouro(touro);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(touro.getIdFichaTouro()).toUri();

        return ResponseEntity.created(uri).build();

    }

}
