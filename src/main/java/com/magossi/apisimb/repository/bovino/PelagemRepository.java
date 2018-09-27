package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Pelagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public interface PelagemRepository extends JpaRepository<Pelagem, Long> {
    @Query("select p from Pelagem p where p.idPelagem = ?1")
    Pelagem buscarPorId(Long id);
}
