package com.magossi.apisimb.domain.tarefa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.bovino.Bovino;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by RafaelMq on 16/11/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Tarefa implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Bovino bovinoMatriz;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TipoTarefaEnum tipoTarefa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imei;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean statusDaTarefa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataConclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean status;


    public Tarefa(){

    }

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public Bovino getBovinoMatriz() {
        return bovinoMatriz;
    }

    public void setBovinoMatriz(Bovino bovinoMatriz) {
        this.bovinoMatriz = bovinoMatriz;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatusDaTarefa() {
        return statusDaTarefa;
    }

    public void setStatusDaTarefa(boolean statusDaTarefa) {
        this.statusDaTarefa = statusDaTarefa;
    }

    public TipoTarefaEnum getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(TipoTarefaEnum tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
