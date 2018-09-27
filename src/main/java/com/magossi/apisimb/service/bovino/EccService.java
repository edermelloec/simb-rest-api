package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Ecc;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.bovino.EccRepository;
import com.magossi.apisimb.service.exceptions.EccExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class EccService {

    @Autowired
    EccRepository eccRepository;

    @Autowired
    BovinoRepository bovinoRepository;


    public Ecc salvar(Ecc ecc){
        if(ecc.getIdECC() != null){

            Ecc e = eccRepository.buscarEccPorId(ecc.getIdECC());
            if(e != null){
                throw new EccExistenteException("Ecc já Existe");
            }
        }
        return eccRepository.save(ecc);
    }


    public Ecc alterar(Ecc ecc){
        buscarId(ecc.getIdECC());
        return eccRepository.save(ecc);

    }

    public void deletar(Long id) {


        try {
            Ecc ecc = eccRepository.buscarEccPorId(id);
            Bovino bovino = bovinoRepository.findByEcc(ecc);
            bovino.getEcc().remove(ecc);
            bovinoRepository.save(bovino);
            eccRepository.delete(ecc);

        } catch (EmptyResultDataAccessException e) {
            throw new EccNaoEncontradoException("O Ecc não pode ser Encontrado");
        }
    }

    public Ecc buscarId(Long id){
        Ecc ecc = eccRepository.buscarEccPorId(id);

        if(ecc==null){
            throw new EccNaoEncontradoException("O Ecc não pode ser Encontrado");
        }
        return ecc;
    }

    public List<Ecc> listar(){
        List<Ecc> eccs = eccRepository.findAll();

        if(eccs==null){
            throw new EccNaoEncontradoException("Lista de Eccs não Encontrada");
        }
        return eccs;
    }
}
