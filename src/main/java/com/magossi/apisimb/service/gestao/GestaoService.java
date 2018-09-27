package com.magossi.apisimb.service.gestao;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Desmama;
import com.magossi.apisimb.domain.bovino.Morto;
import com.magossi.apisimb.domain.matriz.FichaMatriz;
import com.magossi.apisimb.domain.matriz.FichaTouro;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.matriz.FichaMatrizRepository;
import com.magossi.apisimb.repository.matriz.FichaToutroRepository;
import com.magossi.apisimb.repository.matriz.PartoRepository;
import com.magossi.apisimb.service.exceptions.GestaoException;
import com.magossi.apisimb.gestao.GestaoRespositoryBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("ALL")
@Service
public class GestaoService {

    @Autowired
    BovinoRepository bovinoRepository;
    @Autowired
    FichaToutroRepository fichaToutroRepository;
    @Autowired
    FichaMatrizRepository fichaMatrizRepository;


    GestaoRespositoryBanco grb = new GestaoRespositoryBanco();


    public List<Bovino> listarMatriz() {
        List<Bovino> matriz = grb.listarMatriz();

        if (matriz == null) {

            throw new GestaoException("Lista de Matriz não Encontrada");
        }

        return matriz;
    }



    public List<Bovino> listarTouro() {
        List<Bovino> touro = grb.listarTouro();

        if (touro == null) {
            throw new GestaoException("Lista de Touro não Encontrada");
        }

        return touro;
    }

    public List<Bovino> listarFemea() {
        //List<Bovino> femea = grb.listarFemea();
        List<Bovino> femea = bovinoRepository.buscarPorFemea();
        if (femea == null) {
            throw new GestaoException("Lista de Femêa não Encontrada");
        }

        return femea;
    }

    public Bovino buscaNomeMatriz(Integer id){
        Bovino bovino = grb.buscarNomeMatriz(id);
        if (bovino == null) {
            throw new GestaoException("Matriz não Encontrada");
        }
        return bovino;
    }

    public Long salvarVendido(Long id) {
        Long l;

        Bovino bovino;
        bovino = bovinoRepository.findOne(id);
        if(bovino.getFichaMatriz()!=null){
            bovino.getFichaMatriz().setStatus(false);

            bovinoRepository.save(bovino);
        }
        FichaTouro fichaTouro = fichaToutroRepository.buscaTouro(id);
        if(fichaTouro != null){
            fichaTouro.setStatus(false);
            fichaToutroRepository.save(fichaTouro);
        }


        l = grb.salvarVendido(id);
        if (l == null) {
            throw new GestaoException("Venda não foi salvo");
        }

        return l;
    }

    public Long salvarAbatido(Long id) {
        Long l;

        Bovino bovino;
        bovino = bovinoRepository.findOne(id);
        if(bovino.getFichaMatriz()!=null){
            bovino.getFichaMatriz().setStatus(false);

            bovinoRepository.save(bovino);
        }
        FichaTouro fichaTouro = fichaToutroRepository.buscaTouro(id);
        if(fichaTouro != null){
            fichaTouro.setStatus(false);
            fichaToutroRepository.save(fichaTouro);
        }

        l = grb.salvarAbatido(id);
        if (l == null) {
            throw new GestaoException("Bovino abatido não foi salvo");
        }

        return l;
    }


    public FichaTouro salvarTouro(FichaTouro touro) {
        FichaTouro ft;
        ft = grb.salvarTouro(touro);
        if (ft == null) {
            throw new GestaoException("Touro não foi salvo");
        }

        return ft;
    }




    public Bovino salvarBovino(Bovino bovino) {
        Bovino b;
        b = grb.salvarBovino(bovino);
        if (b == null) {
            throw new GestaoException("Bovino não foi salvo");
        }
        return b;
    }

    public Morto salvarMorto(Morto morto) {

        Bovino bovino;
        bovino = bovinoRepository.findOne(morto.getIdBovino());
        if(bovino.getFichaMatriz()!=null){
            bovino.getFichaMatriz().setStatus(false);

            bovinoRepository.save(bovino);
        }
        FichaTouro fichaTouro = fichaToutroRepository.buscaTouro(morto.getIdBovino());
        if(fichaTouro != null){
            fichaTouro.setStatus(false);
            fichaToutroRepository.save(fichaTouro);
        }
        Morto m;
        m = grb.salvarMorte(morto);
        if (m == null) {
            throw new GestaoException("Morte não foi salvo");
        }
        return m;
    }

    public Desmama salvarDesmama(Desmama desmama) {
        Desmama d;
        d = grb.salvarDesmama(desmama);
        if (d == null) {
            throw new GestaoException("Desmama não foi salvo");
        }

        return d;
    }


    public String touroVaca() {

        String json = grb.taxaTouroVaca();

        if (json == null) {
            throw new GestaoException("Touro:Vaca não Encontrada");
        }
        return json;
    }


    public String prenhezTodos() {

        String json = grb.prenhezTodos();

        if (json == null) {
            throw new GestaoException("Prenhez não Encontrada");
        }
        return json;
    }

    public String prenhezNovilha() {

        String json = grb.prenhezNovilha();

        if (json == null) {
            throw new GestaoException("Prenhez não Encontrada");
        }
        return json;
    }

    public String prenhezPrimi() {

        String json = grb.prenhezPrimi();

        if (json == null) {
            throw new GestaoException("Prenhez não Encontrada");
        }
        return json;
    }

    public String prenhezMult() {

        String json = grb.prenhezMult();

        if (json == null) {
            throw new GestaoException("Prenhez não Encontrada");
        }
        return json;
    }

    public String natalidadeTotal() {

        List<FichaMatriz> fichaMatriz = fichaMatrizRepository.findAll();

        for (int i=0;i<fichaMatriz.size();i++){

        }




        String json = grb.natalidadeTodos();

        if (json == null) {
            throw new GestaoException("Natalidade não Encontrada");
        }
        return json;
    }

    public String natalidadeNovilha() {

        String json = grb.natalidadeNovilha();

        if (json == null) {
            throw new GestaoException("Natalidade não Encontrada");
        }
        return json;
    }

    public String natalidadePrimi() {

        String json = grb.natalidadePrimi();

        if (json == null) {
            throw new GestaoException("Natalidade não Encontrada");
        }
        return json;
    }

    public String natalidadeMult() {

        String json = grb.natalidadeMult();

        if (json == null) {
            throw new GestaoException("Natalidade não Encontrada");
        }
        return json;
    }

    public String mediaPesoDesmama() {

        String json = grb.mediaPesoDesmama();

        if (json == null) {
            throw new GestaoException("Natalidade não Encontrada");
        }
        return json;
    }

    public String mediaIdadeDesmama() {

        String json = grb.mediaIdadeDesmama();

        if (json == null) {
            throw new GestaoException("Natalidade não Encontrada");
        }
        return json;
    }

    public String idadePrimeiraCria(String bovino) {

        String json = grb.idadePrimeiraCria(bovino);

        if (json == null) {
            throw new GestaoException("Idade primeira cria não Encontrada");
        }
        return json;
    }

    public String idadeDesmama(String bovino) {

        String json = grb.idadeDesmama(bovino);

        if (json == null) {
            throw new GestaoException("Idade desmama não Encontrada");
        }
        return json;
    }

    public String mortalidadeTotal() {

        String json = grb.mortalidadeTotal();

        if (json == null) {
            throw new GestaoException("Mortalidade não Encontrada");
        }
        return json;
    }

    public String mortalidadePreParto() {

        String json = grb.mortalidadePreParto();

        if (json == null) {
            throw new GestaoException("Mortalidade não Encontrada");
        }
        return json;
    }

    public String mortalidadeAdulto() {

        String json = grb.mortalideAdulto();

        if (json == null) {
            throw new GestaoException("Mortalidade não Encontrada");
        }
        return json;
    }

    public String mortalideJovens() {

        String json = grb.mortalideJovens();

        if (json == null) {
            throw new GestaoException("Mortalidade não Encontrada");
        }
        return json;
    }

    public String mortalideAteDesmama() {

        String json = grb.mortalideAteDesmama();

        if (json == null) {
            throw new GestaoException("Mortalidade não Encontrada");
        }
        return json;
    }

    public String taxaDesmama() {

        String json = grb.taxaDesmama();

        if (json == null) {
            throw new GestaoException("Taxa de Desmama não Encontrada");
        }
        return json;
    }

    public String taxaAbate() {

        String json = grb.taxaAbate();

        if (json == null) {
            throw new GestaoException("Taxa de Abate não Encontrada");
        }
        return json;
    }

    public String taxaDesfrute(String dataInicial, String dataFinal) {

        String json = grb.taxaDesfrute(dataInicial, dataFinal);

        if (json == null) {
            throw new GestaoException("Taxa de Desfrute não Encontrada");
        }
        return json;
    }
}
