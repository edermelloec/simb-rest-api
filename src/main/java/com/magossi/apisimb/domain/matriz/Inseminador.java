package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@Entity
public class Inseminador {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInseminador;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeInseminador;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    public Inseminador(){

    }


    public Long getIdInseminador() {
        return idInseminador;
    }

    public void setIdInseminador(Long idInseminador) {
        this.idInseminador = idInseminador;
    }

    public String getNomeInseminador() {
        return nomeInseminador;
    }

    public void setNomeInseminador(String nomeInseminador) {
        this.nomeInseminador = nomeInseminador;
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
