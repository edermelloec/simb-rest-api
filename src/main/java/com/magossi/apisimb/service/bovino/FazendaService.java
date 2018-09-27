package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Fazenda;
import com.magossi.apisimb.repository.bovino.FazendaRepository;
import com.magossi.apisimb.service.exceptions.FazendaExistenteException;
import com.magossi.apisimb.service.exceptions.FazendaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by RafaelMq on 03/11/2016.
 */


@SuppressWarnings("ALL")
@Service
public class FazendaService {

    @Autowired
    FazendaRepository fazendaRepository;


    public Fazenda salvar(Fazenda fazenda){
        if(fazenda.getIdFazenda() != null){

            Fazenda f = fazendaRepository.buscarPorId(fazenda.getIdFazenda());
            if(f != null){
                throw new FazendaExistenteException("Fazenda já Existe");
            }
        }
        return fazendaRepository.save(fazenda);
    }

    public List<Fazenda> listar(){
        List<Fazenda> fazendas = fazendaRepository.findAll();

        if(fazendas==null){
            throw new FazendaNaoEncontradaException("Lista de Fazendas não Encontrada");
        }
        return fazendas;
    }
}
