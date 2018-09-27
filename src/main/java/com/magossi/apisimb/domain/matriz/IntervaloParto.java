package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@Entity
public class IntervaloParto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntervaloParto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int intervalo;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;





    public Long getIdIntervaloParto() {
        return idIntervaloParto;
    }

    public void setIdIntervaloParto(Long idIntervaloParto) {
        this.idIntervaloParto = idIntervaloParto;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
