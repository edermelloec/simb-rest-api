package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class RacaNaoEncontradaException extends RuntimeException {

    public RacaNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public RacaNaoEncontradaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
