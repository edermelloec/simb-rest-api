package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Peso;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.bovino.PesoRepository;
import com.magossi.apisimb.service.exceptions.PesoExistenteException;
import com.magossi.apisimb.service.exceptions.PesoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class PesoService {

    @Autowired
    PesoRepository pesoRepository;

    @Autowired
    BovinoRepository bovinoRepository;


    public Peso salvar(Peso peso){
        if(peso.getIdPeso() != null){

            Peso p = pesoRepository.findOne(peso.getIdPeso());
            if(p != null){
                throw new PesoExistenteException("Peso já Existe");
            }
        }
        return pesoRepository.save(peso);
    }


    public Peso alterar(Peso peso){
        buscarId(peso.getIdPeso());
        return pesoRepository.save(peso);

    }

    public Peso buscarId(Long id) {

        Peso peso = pesoRepository.findOne(id);

        if(peso==null){
            throw new PesoNaoEncontradoException("O Peso não pode ser Encontrado");
        }
        return peso;
    }


    public void deletar(Long id) {
        try {
            Peso peso = pesoRepository.findOne(id);
            Bovino bovino = bovinoRepository.findByPeso(peso);
            bovino.getPeso().remove(peso);
            bovinoRepository.save(bovino);
            pesoRepository.delete(peso);

        } catch (EmptyResultDataAccessException e) {
            throw new PesoNaoEncontradoException("O Peso não pode ser Encontrado");
        }
    }




    public List<Peso> listar(){
        List<Peso> pesos = pesoRepository.findAll();

        if(pesos==null){
            throw new PesoNaoEncontradoException("Lista de Pesos não Encontrada");
        }
        return pesos;
    }
}
