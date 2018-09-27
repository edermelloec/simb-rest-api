package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.matriz.Inseminador;
import com.magossi.apisimb.repository.matriz.InseminadorRepository;
import com.magossi.apisimb.service.exceptions.FazendaExistenteException;
import com.magossi.apisimb.service.exceptions.FazendaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class InseminadorService {

    @Autowired
    InseminadorRepository inseminadorRepository;


    public Inseminador salvar(Inseminador inseminador){
        if(inseminador.getIdInseminador() != null){

            Inseminador i = inseminadorRepository.findOne(inseminador.getIdInseminador());
            if(i != null){
                throw new FazendaExistenteException("Inseminador já Existe");
            }
        }
        return inseminadorRepository.save(inseminador);
    }

    public List<Inseminador> listar(){
        List<Inseminador> inseminadores = inseminadorRepository.findAll();

        if(inseminadores==null){
            throw new FazendaNaoEncontradaException("Lista de Inseminadores não Encontrada");
        }
        return inseminadores;
    }
}
