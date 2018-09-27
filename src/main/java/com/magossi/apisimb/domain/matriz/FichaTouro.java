package com.magossi.apisimb.domain.matriz;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class FichaTouro {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichaTouro;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idBovino;



    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    public Long getIdFichaTouro() {
        return idFichaTouro;
    }

    public void setIdFichaTouro(Long idFichaTouro) {
        this.idFichaTouro = idFichaTouro;
    }

    public Long getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(Long idBovino) {
        this.idBovino = idBovino;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
