package com.magossi.apisimb.service.bovino;

import com.magossi.apisimb.domain.bovino.Abatido;
import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.repository.bovino.AbatidoRepository;
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
public class AbatidoService {
    @Autowired
    AbatidoRepository abatidoRepository;
    @Autowired
    BovinoRepository bovinoRepository;


    public List<Abatido> buscarTodos() {
        List<Abatido> abatidos = abatidoRepository.findAll();

        if (abatidos == null) {
            throw new BovinoNaoEncontradoException("Lista de Bovinos não Encontrada");
        }
        return abatidos;
    }

    public List<Abatido> buscarPorBovino(String busca) {
        List<Bovino> bovinos = bovinoRepository.buscaComLike(busca);
        List<Abatido> abatidos;
        if (bovinos.size() != 0) {

            abatidos = abatidoRepository.buscarPorBovino(bovinos.get(0).getIdBovino());
        } else {
            abatidos = abatidoRepository.findAll();
        }
        if (abatidos == null) {
            throw new EccNaoEncontradoException("Lista de Tarefas não Encontrada");
        }
        return abatidos;
    }

    public List<Abatido> buscarPorData(Date data1, Date data2) {
        List<Abatido> abatidos = abatidoRepository.buscarPorData(data1, data2);

        if (abatidos == null) {

            throw new BovinoNaoExistenteException("Bovino não Existe");
        }

        return abatidos;
    }

}

