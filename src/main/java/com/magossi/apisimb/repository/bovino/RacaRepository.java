package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public interface RacaRepository extends JpaRepository<Raca, Long> {
    @Query("select r from Raca r where upper(r.nomeRaca) like upper(?1)  and r.status = true")
     Raca buscarPorRaca(String raca);

    @Query("select r from Raca r where r.idRaca =?1 ")
    Raca buscarRacaPorId(Long id);
}
