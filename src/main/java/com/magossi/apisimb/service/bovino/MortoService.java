package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Morto;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.bovino.MortoRepository;
import com.magossi.apisimb.service.exceptions.BovinoNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class MortoService {
    @Autowired
    MortoRepository mortoRepository;

    @Autowired
    BovinoRepository bovinoRepository;

    public List<Morto> buscarTodos(){
        List<Morto> morte = mortoRepository.findAll();

        if(morte==null){
            throw new BovinoNaoEncontradoException("Lista de Bovinos não Encontrada");
        }
        return morte;
    }
    public List<Morto> buscarPorBovino(String busca){
        List<Bovino> bovinos = bovinoRepository.buscaComLike(busca);
        List<Morto> mortos=null;

        if(bovinos.size()!=0) {


            mortos = mortoRepository.buscarPorBovino(bovinos.get(0).getIdBovino());
        }else{
            mortos = mortoRepository.findAll();
        }
        if(mortos==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return mortos;
    }

    public List<Morto> buscarPorDataMorte(Date data1, Date data2) {
        List<Morto> mortos = mortoRepository.buscarPorDataMorte(data1,data2);


        if(mortos.size()==0){
            mortos = mortoRepository.findAll();
        }
        if(mortos==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return mortos;
    }
    public List<Morto> buscarPorCausa(String busca) {
        List<Morto> mortos = mortoRepository.buscarPorCausa(busca);


        if(mortos.size()==0){
            mortos = mortoRepository.findAll();
        }
        if(mortos==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return mortos;
    }

}
