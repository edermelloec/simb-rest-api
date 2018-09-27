package com.magossi.apisimb.service.matriz;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.matriz.Inseminacao;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.matriz.FichaMatrizRepository;
import com.magossi.apisimb.repository.matriz.InseminacaoRepository;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import com.magossi.apisimb.service.exceptions.EccNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.FazendaExistenteException;
import com.magossi.apisimb.service.exceptions.FazendaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@SuppressWarnings("ALL")
@Service
public class InseminacaoService {

    @Autowired
    InseminacaoRepository inseminacaoRepository;

    @Autowired
    BovinoRepository bovinoRepository;

    @Autowired
    FichaMatrizRepository fichaMatrizRepository;


    public Inseminacao salvar(Inseminacao inseminacao){



        if(inseminacao.getIdInseminacao() != null){

            Inseminacao i = inseminacaoRepository.findOne(inseminacao.getIdInseminacao());
            if(i != null){
                throw new FazendaExistenteException("Inseminação já Existe");
            }
        }
        return inseminacaoRepository.save(inseminacao);
    }

    public List<Inseminacao> listar(){
        List<Inseminacao> inseminacoes = inseminacaoRepository.findByStatus(true);

        if(inseminacoes==null){
            throw new FazendaNaoEncontradaException("Lista de Inseminações não Encontrada");
        }
        return inseminacoes;
    }

    public List<Inseminacao> buscarPorId(Long id){
        List<Inseminacao> inseminacoes = inseminacaoRepository.buscarPorId(id);


        return inseminacoes;
    }
//    public List<Inseminacao> buscarPorMatriz(String busca){
//        List<Bovino> bovinos = bovinoRepository.buscarPorMatriz(busca);
//        List<Inseminacao> inseminacaos;
//
//        if(bovinos.size()!=0) {
//
//
//            inseminacaos = inseminacaoRepository.buscarPorMatriz(String.valueOf(bovinos.get(0).getFichaMatriz().getIdFichaMatriz()));
//        }else{
//            inseminacaos = inseminacaoRepository.findByStatus(true);
//        }
//        if(inseminacaos==null){
//            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
//        }
//        return inseminacaos;
//    }
    public List<Inseminacao> buscarPorTouro(String busca){
        List<Inseminacao> inseminacaos;

        inseminacaos = inseminacaoRepository.buscarPorTouro(busca);
        if(inseminacaos.size()==0) {
            inseminacaos = inseminacaoRepository.findByStatus(true);
        }
        if(inseminacaos==null){
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return inseminacaos;
    }
    public List<Inseminacao> buscarPorDataInseminacao(Date data1, Date data2) {
        List<Inseminacao> inseminacaos = inseminacaoRepository.buscarPorDataInseminacao(data1,data2);

        if(inseminacaos==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return inseminacaos;
    }
    public List<Inseminacao> buscarPorDataPrevisaoParto(Date data1, Date data2) {
        List<Inseminacao> inseminacaos = inseminacaoRepository.buscarPorDataPrevisaoParto(data1,data2);

        if(inseminacaos==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return inseminacaos;
    }
    public List<Inseminacao> buscarPorTipo(String tipo) {
        List<Inseminacao> inseminacaos;
        if("Monta".toLowerCase().contains(tipo.toLowerCase())){
            inseminacaos = inseminacaoRepository.findByMonta(true);
        }else if("Inseminacao".toLowerCase().contains(tipo.toLowerCase())){
            inseminacaos = inseminacaoRepository.findByMonta(false);
        }else{
            inseminacaos = inseminacaoRepository.findByStatus(true);
        }


        if(inseminacaos==null){

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return inseminacaos;
    }
//    public List<Inseminacao> buscarPorFuncionario(String busca){
//        String imei=null;
//        if("Sebastiao".toLowerCase().contains(busca.toLowerCase())){
//            imei = "354983059791193";
//        }if("Joao".toLowerCase().contains(busca.toLowerCase())){
//            imei = "123456789";
//        }
//        List<Inseminacao> inseminacaos;
//
//        if(imei!=null) {
//
//            //inseminacaos = inseminacaoRepository.findByImeiContainingAndStatus(imei,true);
//        }else{
//            inseminacaos = inseminacaoRepository.findByStatus(true);
//        }
//        if(inseminacaos==null){
//            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
//        }
//        return inseminacaos;
//    }


}
