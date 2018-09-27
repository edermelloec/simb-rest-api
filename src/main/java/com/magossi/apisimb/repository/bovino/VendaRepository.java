package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("select v from Venda v where v.idBovino = ?1")
    List<Venda> buscarPorBovino(Long bovino);

    @Query("select v from Venda v where v.dataVenda between ?1 and ?2")
    List<Venda> buscarPorData(Date data1, Date data2);
}
