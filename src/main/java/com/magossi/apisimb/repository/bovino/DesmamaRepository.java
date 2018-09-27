package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Desmama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sun.security.krb5.internal.crypto.Des;

import java.util.Date;
import java.util.List;

public interface DesmamaRepository extends JpaRepository<Desmama, Long> {

    @Query("select d from Desmama d where d.idBovino= ?1  ")
    List<Desmama> buscarPorBovino(Long id);


    @Query("select d from Desmama d where d.dataDesmama between ?1 and ?2  and d.status = true")
    List<Desmama> buscarPorData(Date data1, Date data2);
}

