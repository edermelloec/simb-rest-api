package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.matriz.Resultado;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.matriz.ResultadoRepository;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
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
public class ResultadoService {

    @Autowired
    ResultadoRepository resultadoRepository;

    @Autowired
    BovinoRepository bovinoRepository;

    public Resultado salvar(Resultado resultado){
        if(resultado.getIdResultado() != null){

            Resultado r = resultadoRepository.buscarPorId(resultado.getIdResultado());
            if(r != null){
                throw new FazendaExistenteException("Resultado já Existe");
            }
        }
        return resultadoRepository.save(resultado);
    }

    public List<Resultado> listar(){
        List<Resultado> resultados = resultadoRepository.findAll();

        if(resultados==null){
            throw new FazendaNaoEncontradaException("Lista de Resultados não Encontrada");
        }
        return resultados;
    }
    public List<Resultado> buscarPorMatriz(String busca){
        List<Bovino> bovinos = bovinoRepository.buscarPorMatriz(busca);
        List<Resultado> resultados;

        if(bovinos.size()!=0) {
            resultados = resultadoRepository.buscarPorMatriz(bovinos.get(0).getFichaMatriz().getIdFichaMatriz());
        }else{
            resultados = resultadoRepository.findAll();
        }
        if(resultados==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return resultados;
    }
    public List<Resultado> buscarPorResultado(String busca){

        List<Resultado> resultados;
        resultados = resultadoRepository.buscarPorResultado(busca);
        if(resultados==null) {
            resultados = resultadoRepository.findAll();
        }
        if(resultados==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return resultados;
    }
    public List<Resultado> buscarPorInseminacao(Long id){

        List<Resultado> resultados = null;
        resultados = resultadoRepository.buscarPorInseminacao(id);


        return resultados;
    }
}
