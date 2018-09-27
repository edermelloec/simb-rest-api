package com.magossi.apisimb.repository.bovino;



import com.magossi.apisimb.domain.bovino.Ecc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public interface EccRepository extends JpaRepository<Ecc, Long> {

    @Query("select e from Ecc e where e.idECC =?1 ")
    Ecc buscarEccPorId(Long id);
}
