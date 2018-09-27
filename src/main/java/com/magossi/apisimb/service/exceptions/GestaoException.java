package com.magossi.apisimb.service.exceptions;

public class GestaoException extends RuntimeException {

    public GestaoException(String mensagem){
        super(mensagem);
    }

    public GestaoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}

