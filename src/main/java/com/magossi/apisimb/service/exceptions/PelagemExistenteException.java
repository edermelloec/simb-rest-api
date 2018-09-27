package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class PelagemExistenteException extends RuntimeException {

    public PelagemExistenteException(String mensagem){
        super(mensagem);
    }

    public PelagemExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
