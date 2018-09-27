package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Morto {

    public Morto(){

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMorte;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataMorte;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String causa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idBovino;

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Long getIdMorte() {
        return idMorte;
    }

    public void setIdMorte(Long idMorte) {
        this.idMorte = idMorte;
    }

    public Date getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Date dataMorte) {
        this.dataMorte = dataMorte;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(Long idBovino) {
        this.idBovino = idBovino;
    }
}
