package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.DiagnosticoGestacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface DiagGestRepository extends JpaRepository<DiagnosticoGestacao, Long> {

    @Query("select dg from DiagnosticoGestacao dg where dg.idDiagGest =?1 ")
    DiagnosticoGestacao buscaDiagGestPorId(Long id);

}
