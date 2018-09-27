package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class EccNaoEncontradoException extends RuntimeException {

    public EccNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public EccNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
