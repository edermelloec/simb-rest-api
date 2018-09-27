package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Raca;
import com.magossi.apisimb.repository.bovino.RacaRepository;
import com.magossi.apisimb.service.exceptions.RacaExistenteException;
import com.magossi.apisimb.service.exceptions.RacaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class RacaService {

    @Autowired
    RacaRepository racaRepository;


    public Raca salvar(Raca raca){
        if(raca.getIdRaca() != null){

            Raca p = racaRepository.buscarRacaPorId(raca.getIdRaca());
            if(p != null){
                throw new RacaExistenteException("Raca já Existe");
            }
        }
        return racaRepository.save(raca);
    }

    public List<Raca> listar(){
        List<Raca> racas = racaRepository.findAll();

        if(racas==null){
            throw new RacaNaoEncontradaException("Lista de Raças não Encontrada");
        }
        return racas;
    }
}
