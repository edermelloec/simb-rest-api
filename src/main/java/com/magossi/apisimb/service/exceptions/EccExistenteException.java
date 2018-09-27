package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class EccExistenteException extends RuntimeException {

    public EccExistenteException(String mensagem){
        super(mensagem);
    }

    public EccExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
