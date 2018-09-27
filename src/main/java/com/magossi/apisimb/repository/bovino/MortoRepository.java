package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Morto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MortoRepository extends JpaRepository<Morto, Long> {
    @Query("select m from Morto m where m.idBovino= ?1  ")
    List<Morto> buscarPorBovino(Long id);



    @Query("select m from Morto m where upper(m.causa) like upper(?1)")
    List<Morto> buscarPorCausa(String causa);

    @Query("select m from Morto m where m.dataMorte between ?1 and ?2")
    List<Morto> buscarPorDataMorte(Date data1, Date data2);
}
