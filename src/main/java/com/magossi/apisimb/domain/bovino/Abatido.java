package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Abatido {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbatido;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double peso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataAbate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idBovino;

    public Abatido() {
    }

    public Long getIdAbatido() {
        return idAbatido;
    }

    public void setIdAbatido(Long idAbatido) {
        this.idAbatido = idAbatido;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getDataAbate() {
        return dataAbate;
    }

    public void setDataAbate(Date dataAbate) {
        this.dataAbate = dataAbate;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(Long idBovino) {
        this.idBovino = idBovino;
    }
}
