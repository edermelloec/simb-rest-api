package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@Entity
public class Fazenda {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idFazenda;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String nomeFazenda;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String enderecoFazenda;


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Date dataInclusao = new Date();


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    public Boolean status;

    public Fazenda(){

    }


    public Long getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(Long idFazenda) {
        this.idFazenda = idFazenda;
    }

    public String getNomeFazenda() {
        return nomeFazenda;
    }

    public void setNomeFazenda(String nomeFazenda) {
        this.nomeFazenda = nomeFazenda;
    }

    public String getEnderecoFazenda() {
        return enderecoFazenda;
    }

    public void setEnderecoFazenda(String enderecoFazenda) {
        this.enderecoFazenda = enderecoFazenda;
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
