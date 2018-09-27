package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.FichaTouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FichaToutroRepository extends JpaRepository<FichaTouro, Long> {

    @Query("select ft from FichaTouro ft where  ft.idBovino = ?1 ")
    FichaTouro buscaTouro(Long id);
}
