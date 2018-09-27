package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 03/11/2016.
 */
public class ProprietarioNaoEncontradoException extends RuntimeException {

    public ProprietarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public ProprietarioNaoEncontradoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
