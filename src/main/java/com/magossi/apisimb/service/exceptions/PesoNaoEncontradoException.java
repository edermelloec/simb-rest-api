package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class PesoNaoEncontradoException extends RuntimeException {

    public PesoNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public PesoNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
