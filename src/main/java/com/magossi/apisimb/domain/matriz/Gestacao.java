package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.bovino.Bovino;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Gestacao {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInic = new Date();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataFinal = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private FichaMatriz idFichaMatriz;

    public Long getIdGestacao() {
        return idGestacao;
    }

    public void setIdGestacao(Long idGestacao) {
        this.idGestacao = idGestacao;
    }

    public Date getDataInic() {
        return dataInic;
    }

    public void setDataInic(Date dataInic) {
        this.dataInic = dataInic;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public FichaMatriz getIdFichaMatriz() {
        return idFichaMatriz;
    }

    public void setIdFichaMatriz(FichaMatriz idFichaMatriz) {
        this.idFichaMatriz = idFichaMatriz;
    }
}
