package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 20/05/2016.
 */
public class BovinoNaoEncontradoException extends RuntimeException {

    public BovinoNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public BovinoNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
