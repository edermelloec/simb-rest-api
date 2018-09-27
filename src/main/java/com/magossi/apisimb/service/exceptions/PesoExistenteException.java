package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class PesoExistenteException extends RuntimeException {

    public PesoExistenteException(String mensagem){
        super(mensagem);
    }

    public PesoExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
