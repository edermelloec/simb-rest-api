package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class ProprietarioExistenteException extends RuntimeException {

    public ProprietarioExistenteException(String mensagem){
        super(mensagem);
    }

    public ProprietarioExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
