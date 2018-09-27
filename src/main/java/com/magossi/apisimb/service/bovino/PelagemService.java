package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Pelagem;
import com.magossi.apisimb.repository.bovino.PelagemRepository;
import com.magossi.apisimb.service.exceptions.PelagemExistenteException;
import com.magossi.apisimb.service.exceptions.PelagemNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class PelagemService {

    @Autowired
    PelagemRepository pelagemRepository;


    public Pelagem salvar(Pelagem pelagem){
        if(pelagem.getIdPelagem() != null){

            Pelagem p = pelagemRepository.buscarPorId(pelagem.getIdPelagem());
            if(p != null){
                throw new PelagemExistenteException("Pelagem já Existe");
            }
        }
        return pelagemRepository.save(pelagem);
    }

    public List<Pelagem> listar(){
        List<Pelagem> pelagems = pelagemRepository.findAll();

        if(pelagems==null){
            throw new PelagemNaoEncontradaException("Lista de Pelagens não Encontrada");
        }
        return pelagems;
    }
}
