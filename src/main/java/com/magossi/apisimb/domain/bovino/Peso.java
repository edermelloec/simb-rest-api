package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 03/11/2016.
 */


@Entity
public class Peso {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataPesagem;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double peso;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Long getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(Long idPeso) {
        this.idPeso = idPeso;
    }

    public Date getDataPesagem() {
        return dataPesagem;
    }

    public void setDataPesagem(Date dataPesagem) {
        this.dataPesagem = dataPesagem;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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
