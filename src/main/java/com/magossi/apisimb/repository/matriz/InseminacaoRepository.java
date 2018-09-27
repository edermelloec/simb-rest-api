package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.Inseminacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface InseminacaoRepository extends JpaRepository<Inseminacao, Long> {

    List<Inseminacao> findByStatus(Boolean status);

    //List<Inseminacao> findByImeiContainingAndStatus(String imei,Boolean status);

    List<Inseminacao> findByMonta(Boolean status);

//    @Query("select i from Inseminacao i where i.matriz = ?1  and i.status = true")
//    List<Inseminacao> buscarPorMatriz(String id);

    @Query("select i from Inseminacao i where upper(i.touro) like upper(?1)  and i.status = true")
    List<Inseminacao> buscarPorTouro(String touro);

    @Query("select i from Inseminacao i where i.dataDaInseminacao between ?1 and ?2  and i.status = true ")
    List<Inseminacao> buscarPorDataInseminacao(Date data1,Date data2);

    @Query("select i from Inseminacao i where i.previsaoParto between ?1 and ?2  and i.status = true ")
    List<Inseminacao> buscarPorDataPrevisaoParto(Date data1,Date data2);

    @Query("select i from Inseminacao i where i.idInseminacao = ?1 and i.status = true ")
    List<Inseminacao> buscarPorId(Long id);

    @Query("select i from Inseminacao i where i.idInseminacao = ?1")
    Inseminacao buscarInseminacaoPorId(Long id);

}
