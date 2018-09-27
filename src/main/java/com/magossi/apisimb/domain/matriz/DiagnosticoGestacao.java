package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@Entity
public class DiagnosticoGestacao {



    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiagGest;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataDiagnostico;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Resultado resultadoDiagGest;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Long getIdDiagGest() {
        return idDiagGest;
    }

    public void setIdDiagGest(Long idDiagGest) {
        this.idDiagGest = idDiagGest;
    }

    public Date getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(Date dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }

    public Resultado getResultadoDiagGest() {
        return resultadoDiagGest;
    }

    public void setResultadoDiagGest(Resultado resultadoDiagGest) {
        this.resultadoDiagGest = resultadoDiagGest;
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
