package com.magossi.apisimb.handler;

import com.magossi.apisimb.domain.bovino.Erro;
import com.magossi.apisimb.service.exceptions.BovinoNaoEncontradoException;
import com.magossi.apisimb.service.exceptions.BovinoNaoExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RafaelMq on 20/05/2016.
 */

@ControllerAdvice
public class ResourcesExceptionHandler {

    // Bovino

    @ExceptionHandler(BovinoNaoExistenteException.class)
    public ResponseEntity<Erro> handleBovinoNaoExistenteException
            (BovinoNaoExistenteException e, HttpServletRequest request) {

        Erro erro = new Erro();

        erro.setStatus(404l);
        erro.setTitulo("O bovino nao existe !!");
        erro.setMensagemDesenvolvedor("http://erros-simb.magossi.com/404");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }

    @ExceptionHandler(BovinoNaoEncontradoException.class)
    public ResponseEntity<Erro> handleBovinoNaoEncontradoException
            (BovinoNaoEncontradoException e, HttpServletRequest request) {

        Erro erro = new Erro();

        erro.setStatus(404l);
        erro.setTitulo("O Bovino nao pode ser encontrado !!");
        erro.setMensagemDesenvolvedor("http://erros-simb.magossi.com/404");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }




//    @ExceptionHandler(DataIntegrityViolationException.class)    // trata o erro de criar um livro com autor inixistente
//    public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
//            (DataIntegrityViolationException e, HttpServletRequest request) {
//
//        DetalhesErro erro = new DetalhesErro();
//
//        erro.setStatus(400l);
//        erro.setTitulo("Requisição invalida");
//        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
//        erro.setTimestamp(System.currentTimeMillis());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
//
//    }

}
