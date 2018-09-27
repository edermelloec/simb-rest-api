package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class RacaExistenteException extends RuntimeException {

    public RacaExistenteException(String mensagem){
        super(mensagem);
    }

    public RacaExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
