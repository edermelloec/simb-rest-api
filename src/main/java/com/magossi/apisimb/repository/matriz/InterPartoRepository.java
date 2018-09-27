package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.IntervaloParto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface InterPartoRepository extends JpaRepository<IntervaloParto, Long> {
    @Query("select ip from IntervaloParto ip where ip.idIntervaloParto = ?1")
    IntervaloParto buscarPorId(Long id);
}
