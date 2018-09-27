package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    @Query("select p from Proprietario p where p.idProprietario = ?1")
    Proprietario buscarPorId(Long id);
}
