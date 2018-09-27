package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Fazenda;
import com.magossi.apisimb.domain.bovino.Raca;
import com.magossi.apisimb.domain.matriz.FichaMatriz;
import com.magossi.apisimb.repository.bovino.*;
import com.magossi.apisimb.service.exceptions.BovinoExistenteException;
import com.magossi.apisimb.service.exceptions.BovinoNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 20/05/2016.
 */

@SuppressWarnings("ALL")
@Service
public class BovinoService {

    @Autowired
    BovinoRepository bovinoRepository;

    @Autowired
    FazendaRepository fazendaRepository;

    @Autowired
    PelagemRepository pelagemRepository;

    @Autowired
    ProprietarioRepository proprietarioRepository;

    @Autowired
    RacaRepository racaRepository;

    @Autowired
    EccRepository eccRepository;


    public Bovino salvar(Bovino bovino){
        if(bovino.getTag() != null){

            Bovino b = bovinoRepository.findByTag(bovino.getTag());
            if(b != null){
                throw new BovinoExistenteException("Bovino já Existe");
            }
        }

        return bovinoRepository.save(bovino);

    }


    public Bovino alterar(Bovino bovino){

        return bovinoRepository.save(bovino);

    }



    public Bovino buscarTag(String tag){
        Bovino bovino = bovinoRepository.findByTag(tag);

        if(bovino==null){
            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }

    public List<Bovino> buscarNomeBovino(String nome){
        List<Bovino> bovino = bovinoRepository.buscaComLike(nome);

        if(bovino==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }
    public List<Bovino> buscarPorRaca(String nome) {
        Raca idRaca =  racaRepository.buscarPorRaca(nome);
        List<Bovino> bovino = bovinoRepository.buscaPorRaca(idRaca);

        if(bovino==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }
    public List<Bovino> buscarPorFazenda(String nome) {
        Fazenda idFazenda = fazendaRepository.buscarPorFazenda(nome);
        List<Bovino> bovino = bovinoRepository.buscarPorFazenda(idFazenda);

        if(bovino==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }
    public List<Bovino> buscarPorData(Date data) {
        List<Bovino> bovino = bovinoRepository.buscarPorData(data);

        if(bovino==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }

    public List<Bovino> buscarMatriz(String nome){
        List<Bovino> bovino = bovinoRepository.buscaComLike(nome);

        if(bovino==null){
            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }

    public List<Bovino> buscarMae(String mae){
        List<Bovino> bovino = bovinoRepository.findByMaeContaining(mae);

        if(bovino==null){
            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }

    public List<Bovino> buscarBezerro(){
        List<Bovino> bovino = bovinoRepository.buscarBezerro();

        if(bovino==null){
            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }

    public List<Bovino> buscarMatrizInseminada(){
        List<Bovino> bovino = bovinoRepository.buscarMatrizInseminada();

        if(bovino==null){
            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return bovino;
    }


    public Bovino buscarId(Long id){
        Bovino bovino = bovinoRepository.findOne(id);

        if(bovino==null){
            throw new BovinoNaoEncontradoException("Bovino não Encontrado");
        }
        return bovino;
    }

    public Bovino buscarIdMatriz(FichaMatriz fichaMatriz){
        Bovino bovino = bovinoRepository.buscarPorIdMatriz(fichaMatriz);

        if(bovino==null){
            throw new BovinoNaoEncontradoException("Bovino não Encontrado");
        }
        return bovino;
    }

    public List<Bovino> buscarTodos(){
        List<Bovino> bovino = bovinoRepository.buscarOrdenadoNome();

        if(bovino==null){
            throw new BovinoNaoEncontradoException("Lista de Bovinos não Encontrada");
        }
        return bovino;
    }

    public List<Bovino> buscarTodosAtivos(){
        List<Bovino> bovino = bovinoRepository.findByStatusOrderByNomeBovino(true);

        if(bovino==null){
            throw new BovinoNaoEncontradoException("Lista de Bovinos não Encontrada");
        }
        return bovino;
    }


}
