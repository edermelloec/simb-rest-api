package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class FazendaExistenteException extends RuntimeException {

    public FazendaExistenteException(String mensagem){
        super(mensagem);
    }

    public FazendaExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
