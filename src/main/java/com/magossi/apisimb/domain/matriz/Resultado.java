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
public class Resultado {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String resultado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idFichaMatriz;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idInseminacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataResultado;


    // Getters e Setter


    public Long getIdInseminacao() {
        return idInseminacao;
    }

    public void setIdInseminacao(Long idInseminacao) {
        this.idInseminacao = idInseminacao;
    }

    public Date getDataResultado() {
        return dataResultado;
    }

    public void setDataResultado(Date dataResultado) {
        this.dataResultado = dataResultado;
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

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Long getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }
}
