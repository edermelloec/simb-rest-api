package com.magossi.apisimb.repository.matriz;

import com.magossi.apisimb.domain.matriz.DiagnosticoGestacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RafaelMq on 04/11/2016.
 */
public interface DiagGestRepository extends JpaRepository<DiagnosticoGestacao, Long> {
}
