package com.magossi.apisimb.service.exceptions;

/**
 * Created by RafaelMq on 20/05/2016.
 */
public class BovinoNaoExistenteException extends  RuntimeException {



    public BovinoNaoExistenteException(String mensagem){
        super(mensagem);
    }

    public BovinoNaoExistenteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}


