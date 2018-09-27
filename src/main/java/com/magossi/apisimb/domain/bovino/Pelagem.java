package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@Entity
public class Pelagem {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelagem;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomePelagem;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Long getIdPelagem() {
        return idPelagem;
    }

    public String getNomePelagem() {
        return nomePelagem;
    }

    public void setIdPelagem(Long idPelagem) {
        this.idPelagem = idPelagem;
    }

    public void setNomePelagem(String nomePelagem) {
        this.nomePelagem = nomePelagem;
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
