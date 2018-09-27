package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Abatido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AbatidoRepository extends JpaRepository<Abatido, Long> {

    @Query("select a from Abatido a where a.idBovino = ?1")
    List<Abatido> buscarPorBovino(Long bovino);

    @Query("select a from Abatido a where a.dataAbate between ?1 and ?2")
    List<Abatido> buscarPorData(Date data1, Date data2);

}
