package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class FazendaNaoEncontradaException extends RuntimeException {

    public FazendaNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public FazendaNaoEncontradaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
