package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.bovino.Bovino;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RafaelMq on 04/11/2016.
 */

@Entity
public class Inseminacao {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInseminacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean monta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String touro;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataDaInseminacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Parto parto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Inseminador inseminador;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date previsaoParto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    public Parto getParto() {
        return parto;
    }

    public void setParto(Parto parto) {
        this.parto = parto;
    }

    @Override
    public String toString() {
        return "Inseminacao{" +
                "idInseminacao=" + idInseminacao +
                ", monta=" + monta +
                ", touro='" + touro + '\'' +
                ", dataDaInseminacao=" + dataDaInseminacao +
                ", parto=" + parto +
                ", inseminador=" + inseminador +
                ", previsaoParto=" + previsaoParto +
                ", dataInclusao=" + dataInclusao +
                ", status=" + status +
                '}';
    }

    public Inseminador getInseminador() {
        return inseminador;
    }

    public void setInseminador(Inseminador inseminador) {
        this.inseminador = inseminador;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Long getIdInseminacao() {
        return idInseminacao;
    }

    public void setIdInseminacao(Long idInseminacao) {
        this.idInseminacao = idInseminacao;
    }

    public Boolean getMonta() {
        return monta;
    }

    public void setMonta(Boolean monta) {
        this.monta = monta;
    }

    public String getTouro() {
        return touro;
    }

    public void setTouro(String touro) {
        this.touro = touro;
    }

    public Date getDataDaInseminacao() {
        return dataDaInseminacao;
    }

    public void setDataDaInseminacao(Date dataDaInseminacao) {
        this.dataDaInseminacao = dataDaInseminacao;
    }





    public Date getPrevisaoParto() {
        return previsaoParto;
    }

    public void setPrevisaoParto(Date previsaoParto) {
        this.previsaoParto = previsaoParto;
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
