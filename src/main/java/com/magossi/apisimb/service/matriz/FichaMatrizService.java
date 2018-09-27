package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.matriz.FichaMatriz;
import com.magossi.apisimb.repository.matriz.FichaMatrizRepository;
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
public class FichaMatrizService {

    @Autowired
    FichaMatrizRepository fichaMatrizRepository;


    public FichaMatriz salvar(FichaMatriz fichaMatriz){
        if(fichaMatriz.getIdFichaMatriz() != null){

            FichaMatriz f = fichaMatrizRepository.findOne(fichaMatriz.getIdFichaMatriz());
            if(f != null){
                throw new FazendaExistenteException("Ficha da Matriz já Existe");
            }
        }
        return fichaMatrizRepository.save(fichaMatriz);
    }

    public List<FichaMatriz> listar(){
        List<FichaMatriz> fichaMatrizs = fichaMatrizRepository.findAll();

        if(fichaMatrizs==null){
            throw new FazendaNaoEncontradaException("Lista de Fichas da Matriz não Encontrada");
        }
        return fichaMatrizs;
    }



    public List<FichaMatriz> buscarMatrizInseminada(){
        List<FichaMatriz> fichaMatrizs = fichaMatrizRepository.findAll();

        if(fichaMatrizs==null){
            throw new FazendaNaoEncontradaException("Lista de Fichas da Matriz não Encontrada");
        }
        return fichaMatrizs;
    }
}
