package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Peso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public interface PesoRepository extends JpaRepository<Peso, Long> {

    @Query("select p from Peso p where p.idPeso =?1 ")
    Peso buscarPesoPorId(Long id);
}
