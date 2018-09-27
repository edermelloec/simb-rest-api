package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Fazenda;
import com.magossi.apisimb.domain.bovino.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    @Query("select f from Fazenda f where upper(f.nomeFazenda) like upper(?1)  and f.status = true")
    Fazenda buscarPorFazenda(String fazenda);

    @Query("select f from Fazenda f where f.idFazenda = ?1")
    Fazenda buscarPorId(Long id);
}
