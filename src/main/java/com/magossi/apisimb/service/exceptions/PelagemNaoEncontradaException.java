package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class PelagemNaoEncontradaException extends RuntimeException {

    public PelagemNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public PelagemNaoEncontradaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
