package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Proprietario;
import com.magossi.apisimb.repository.bovino.ProprietarioRepository;
import com.magossi.apisimb.service.exceptions.ProprietarioExistenteException;
import com.magossi.apisimb.service.exceptions.ProprietarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */


@SuppressWarnings("ALL")
@Service
public class ProprietarioService {

    @Autowired
    ProprietarioRepository proprietarioRepository;


    public Proprietario salvar(Proprietario proprietario){
        if(proprietario.getIdProprietario() != null){

            Proprietario p = proprietarioRepository.findOne(proprietario.getIdProprietario());
            if(p != null){
                throw new ProprietarioExistenteException("Proprietario já Existe");
            }
        }
        return proprietarioRepository.save(proprietario);
    }

    public List<Proprietario> listar(){
        List<Proprietario> proprietarios = proprietarioRepository.findAll();

        if(proprietarios==null){
            throw new ProprietarioNaoEncontradoException("Lista de Proprietarios não Encontrada");
        }
        return proprietarios;
    }
}
