package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.matriz.IntervaloParto;
import com.magossi.apisimb.repository.matriz.InterPartoRepository;
import com.magossi.apisimb.service.exceptions.FazendaExistenteException;
import com.magossi.apisimb.service.exceptions.FazendaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class InterPartoService {

    @Autowired
    InterPartoRepository m_interPartoRepository;


    public IntervaloParto salvar(IntervaloParto intervaloParto){
        if(intervaloParto.getIdIntervaloParto() != null){

            IntervaloParto i = m_interPartoRepository.buscarPorId(intervaloParto.getIdIntervaloParto());
            if(i != null){
                throw new FazendaExistenteException("Intervalo de Parto já Existe");
            }
        }
        return m_interPartoRepository.save(intervaloParto);
    }

    public List<IntervaloParto> listar(){
        List<IntervaloParto> intervalosParto = m_interPartoRepository.findAll();

        if(intervalosParto==null){
            throw new FazendaNaoEncontradaException("Lista de Intervalos de Parto não Encontrada");
        }
        return intervalosParto;
    }
}
