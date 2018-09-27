package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.FichaMatriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface FichaMatrizRepository extends JpaRepository<FichaMatriz, Long> {
    @Query("select f from FichaMatriz f where f.status=true order by f.idFichaMatriz")
    List<FichaMatriz> buscaMatrizAtiva();

    @Query("select fm from FichaMatriz fm where fm.idFichaMatriz =?1 ")
    FichaMatriz buscarPorId(Long id);
}
