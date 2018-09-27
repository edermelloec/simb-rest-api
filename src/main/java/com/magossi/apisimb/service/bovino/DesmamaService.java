package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Desmama;
import com.magossi.apisimb.domain.bovino.Morto;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.bovino.DesmamaRepository;
import com.magossi.apisimb.service.exceptions.BovinoNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class DesmamaService {

    @Autowired
    DesmamaRepository desmamaRepository;

    @Autowired
    BovinoRepository bovinoRepository;

    public List<Desmama> buscarTodos(){
        List<Desmama> desmama = desmamaRepository.findAll();

        if(desmama==null){
            throw new BovinoNaoEncontradoException("Lista de Bovinos não Encontrada");
        }
        return desmama;
    }

    public List<Desmama> buscarPorBovino(String busca){
        List<Bovino> bovinos = bovinoRepository.buscaComLike(busca);
        List<Desmama> desmamas=null;

        if(bovinos.size()!=0) {


            desmamas = desmamaRepository.buscarPorBovino(bovinos.get(0).getIdBovino());
        }else{
            desmamas = desmamaRepository.findAll();
        }
        if(desmamas==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return desmamas;
    }
//    public List<Desmama> buscarPorMatriz(String busca){
//        List<Bovino> bovinos = bovinoRepository.buscarPorMatriz(busca);
//        List<Desmama> desmamas;
//
//        if(bovinos.size()!=0) {
//
//
//            desmamas = desmamaRepository.buscarPorMatriz(bovinos.get(0).getFichaMatriz().getIdFichaMatriz());
//        }else{
//            desmamas = desmamaRepository.findAll();
//        }
//        if(desmamas==null){
//            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
//        }
//        return desmamas;
//    }
    public List<Desmama> buscarPorData(Date data1,Date data2) {
        List<Desmama> desmamas = desmamaRepository.buscarPorData(data1,data2);

        if(desmamas==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return desmamas;
    }
}
