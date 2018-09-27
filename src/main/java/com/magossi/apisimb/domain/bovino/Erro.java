package com.magossi.apisimb.domain.bovino;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by RafaelMq on 20/05/2016.
 */
public class Erro {

    private Long id;
    private String titulo;
    private Long status;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Long timestamp;
    private String mensagemDesenvolvedor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }

    public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }
}



