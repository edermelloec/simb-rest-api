package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.matriz.DiagnosticoGestacao;
import com.magossi.apisimb.repository.matriz.DiagGestRepository;
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
public class DiagGestService {


    @Autowired
    DiagGestRepository diagGestRepository;


    public DiagnosticoGestacao salvar(DiagnosticoGestacao diagGest){
        if(diagGest.getIdDiagGest() != null){

            DiagnosticoGestacao d = diagGestRepository.findOne(diagGest.getIdDiagGest());
            if(d != null){
                throw new FazendaExistenteException("Diagnostico de Gestação já Existe");
            }
        }
        return diagGestRepository.save(diagGest);
    }

    public List<DiagnosticoGestacao> listar(){
        List<DiagnosticoGestacao> diagnosticoGestacoes = diagGestRepository.findAll();

        if(diagnosticoGestacoes==null){
            throw new FazendaNaoEncontradaException("Lista de Diagnosticos de Gestação não Encontrada");
        }
        return diagnosticoGestacoes;
    }
}
