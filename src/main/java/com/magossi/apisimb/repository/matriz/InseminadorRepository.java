package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.Inseminador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface InseminadorRepository extends JpaRepository<Inseminador, Long> {
    @Query("select i from Inseminador i where i.idInseminador = ?1")
    Inseminador buscarPorId(Long id);

}
