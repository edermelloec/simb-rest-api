package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.bovino.Bovino;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@Entity
public class Parto {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataParto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idFichaMatriz;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idInseminacao;

    public Long getIdInseminacao() {
        return idInseminacao;
    }

    public void setIdInseminacao(Long idInseminacao) {
        this.idInseminacao = idInseminacao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdFichaMatriz() {
        return idFichaMatriz;
    }

    public void setIdFichaMatriz(Long idFichaMatriz) {
        this.idFichaMatriz = idFichaMatriz;
    }

    public Long getIdParto() {
        return idParto;
    }

    public void setIdParto(Long idParto) {
        this.idParto = idParto;
    }

    public Date getDataParto() {
        return dataParto;
    }

    public void setDataParto(Date dataParto) {
        this.dataParto = dataParto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
