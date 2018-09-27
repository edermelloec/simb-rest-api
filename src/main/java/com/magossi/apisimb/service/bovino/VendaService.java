package com.magossi.apisimb.service.bovino;


import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Morto;
import com.magossi.apisimb.domain.bovino.Venda;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.bovino.VendaRepository;
import com.magossi.apisimb.service.exceptions.BovinoNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    BovinoRepository bovinoRepository;


    public List<Venda> buscarTodos(){
        List<Venda> venda = vendaRepository.findAll();

        if(venda==null){
            throw new BovinoNaoEncontradoException("Lista de Bovinos não Encontrada");
        }
        return venda;
    }

    public List<Venda> buscarPorBovino(String busca){
        List<Bovino> bovinos = bovinoRepository.buscaComLike(busca);
        List<Venda> vendas;
        if(bovinos.size()!=0) {

            vendas = vendaRepository.buscarPorBovino(bovinos.get(0).getIdBovino());
        }else{
            vendas = vendaRepository.findAll();
        }
        if(vendas==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return vendas;
    }
    public List<Venda> buscarPorData(Date data1, Date data2) {
        List<Venda> vendas = vendaRepository.buscarPorData(data1,data2);

        if(vendas==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return vendas;
    }

}
