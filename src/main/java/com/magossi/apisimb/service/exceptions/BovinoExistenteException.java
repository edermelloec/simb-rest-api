package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 22/05/2016.
 */
public class BovinoExistenteException extends RuntimeException {

    public BovinoExistenteException(String mensagem){
        super(mensagem);
    }

    public BovinoExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
