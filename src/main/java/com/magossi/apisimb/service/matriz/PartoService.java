package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.matriz.Parto;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.matriz.PartoRepository;
import com.magossi.apisimb.service.exceptions.*;
import com.magossi.apisimb.gestao.GestaoRespositoryBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class PartoService {

    @Autowired
    PartoRepository partoRepository;

    @Autowired
    BovinoRepository bovinoRepository;

    GestaoRespositoryBanco grb = new GestaoRespositoryBanco();


    public Parto salvar(Parto parto) {
        if (parto.getIdParto() != null) {

            Parto p = partoRepository.buscarPartoPorId(parto.getIdParto());
            if (p != null) {
                throw new FazendaExistenteException("Intervalo de Parto já Existe");
            }
        }
        return partoRepository.save(parto);
    }
    public List<Parto> listar() {
        List<Parto> partos = partoRepository.findAll();

        if (partos == null) {
            throw new GestaoException("Lista de Intervalos de Parto não Encontrada");
        }
        return partos;
    }
    public List<Parto> buscarPorId(Long id){
        List<Parto> parto = partoRepository.buscarPorId(id);

        if(parto==null){
            throw new FazendaNaoEncontradaException("Lista de Inseminações não Encontrada");
        }
        return parto;
    }
    public List<Parto> buscarPorMatriz(String busca){
        List<Bovino> bovinos = bovinoRepository.buscarPorMatriz(busca);
        List<Parto> partos=null;

        if(bovinos.size()!=0) {


            partos = partoRepository.buscarPorMatriz(bovinos.get(0).getFichaMatriz().getIdFichaMatriz());
        }else{
            partos = partoRepository.findAll();
        }
        if(partos==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return partos;
    }
    public List<Parto> buscarPorDataParto(Date data1, Date data2) {
        List<Parto> partos = partoRepository.buscarPorDataParto(data1,data2);



        if(partos==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return partos;
    }
    public List<Parto> buscarPorDescricao(String busca){
        List<Parto> partos;

        partos = partoRepository.buscarPorDescricao(busca);
        if(partos.size()==0) {
            partos = partoRepository.findAll();
        }
        if(partos==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return partos;
    }
    public List<Parto> buscarPorStatus(String busca){
        List<Parto> partos;

        partos = partoRepository.buscarPorStatus(busca);
        if(partos.size()==0) {
            partos = partoRepository.findAll();
        }
        if(partos==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return partos;
    }

    public Parto salvarParto(Parto parto) {
        Parto p;
        p = partoRepository.save(parto);

        if (p==null){
            throw new GestaoException("Parto não foi salvo");
        }
        return p;
    }
    public void salvarQtdParto(Integer id){

        grb.salvarQtdParto(id);

    }

}
