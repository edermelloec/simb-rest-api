package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.matriz.FichaMatriz;
import javafx.beans.binding.LongExpression;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Desmama {

    public Desmama(){

    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesmama;




    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataDesmama;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double peso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idBovino;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idFichaMatriz;

    public Long getIdFichaMatriz() {
        return idFichaMatriz;
    }

    public void setIdFichaMatriz(Long idFichaMatriz) {
        this.idFichaMatriz = idFichaMatriz;
    }

    public Long getIdDesmama() {
        return idDesmama;
    }

    public void setIdDesmama(Long idDesmama) {
        this.idDesmama = idDesmama;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Date getDataDesmama() {
        return dataDesmama;
    }

    public void setDataDesmama(Date dataDesmama) {
        this.dataDesmama = dataDesmama;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Long getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(Long idBovino) {
        this.idBovino = idBovino;
    }
}
