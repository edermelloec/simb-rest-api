package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@Entity
public class Ecc {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idECC;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer escore;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Long getIdECC() {
        return idECC;
    }

    public void setIdECC(Long idECC) {
        this.idECC = idECC;
    }

    public Integer getEscore() {
        return escore;
    }

    public void setEscore(Integer escore) {
        this.escore = escore;
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
