package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 03/11/2016.
 */

@Entity
public class Proprietario {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProprietario;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeProprietario;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Long getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Long idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
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
