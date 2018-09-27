package com.magossi.apisimb.domain.matriz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.bovino.Bovino;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 04/11/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class FichaMatriz {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichaMatriz;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Inseminacao> inseminacao;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DiagnosticoGestacao> diagnosticoGestacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IntervaloParto> intervaloParto;




    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long quantParto;



    public Long getIdFichaMatriz() {
        return idFichaMatriz;
    }

    public void setIdFichaMatriz(Long idFichaMatriz) {
        this.idFichaMatriz = idFichaMatriz;
    }

    public List<Inseminacao> getInseminacao() {
        return inseminacao;
    }

    public void setInseminacao(List<Inseminacao> inseminacao) {
        this.inseminacao = inseminacao;
    }

    public List<DiagnosticoGestacao> getDiagnosticoGestacao() {
        return diagnosticoGestacao;
    }

    public void setDiagnosticoGestacao(List<DiagnosticoGestacao> diagnosticoGestacao) {
        this.diagnosticoGestacao = diagnosticoGestacao;
    }

    public List<IntervaloParto> getIntervaloParto() {
        return intervaloParto;
    }

    public void setIntervaloParto(List<IntervaloParto> intervaloParto) {
        this.intervaloParto = intervaloParto;
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
