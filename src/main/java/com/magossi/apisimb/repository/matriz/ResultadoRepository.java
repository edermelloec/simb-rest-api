package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {



    @Query("select r from Resultado r where r.idFichaMatriz = ?1")
    List<Resultado> buscarPorMatriz(Long id);

    @Query("select r from Resultado r where upper(r.resultado) like upper(?1)")
    List<Resultado> buscarPorResultado(String touro);

    @Query("select r from Resultado r where r.idInseminacao = ?1")
    List<Resultado> buscarPorInseminacao(Long id);
}
