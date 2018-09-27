package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.magossi.apisimb.domain.matriz.FichaMatriz;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 15/05/2016.
 */

@Entity
public class Bovino implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBovino;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tag;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeBovino;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean genero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pai;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mae;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataFalecimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Raca raca;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Pelagem pelagem;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Fazenda fazenda;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    private Proprietario proprietario;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ecc> ecc;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Peso> peso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    private FichaMatriz fichaMatriz;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlFoto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String situacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dataInclusao = new Date();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;


    public Bovino() {

    }

//    public Date getDataFalecimento() {
//        return dataFalecimento;
//    }
//
//    public void setDataFalecimento(Date dataFalecimento) {
//        this.dataFalecimento = dataFalecimento;
//    }
//
//    public String getSituacao() {
//        return situacao;
//    }
//
//    public void setSituacao(String situacao) {
//        this.situacao = situacao;
//    }

    public Long getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(Long idBovino) {
        this.idBovino = idBovino;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNomeBovino() {
        return nomeBovino;
    }

    public void setNomeBovino(String nomeBovino) {
        this.nomeBovino = nomeBovino;
    }

    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Pelagem getPelagem() {
        return pelagem;
    }

    public void setPelagem(Pelagem pelagem) {
        this.pelagem = pelagem;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Ecc> getEcc() {
        return ecc;
    }

    public void setEcc(List<Ecc> ecc) {
        this.ecc = ecc;
    }

    public List<Peso> getPeso() {
        return peso;
    }

    public void setPeso(List<Peso> peso) {
        this.peso = peso;
    }

    public FichaMatriz getFichaMatriz() {
        return fichaMatriz;
    }

    public void setFichaMatriz(FichaMatriz fichaMatriz) {
        this.fichaMatriz = fichaMatriz;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
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
