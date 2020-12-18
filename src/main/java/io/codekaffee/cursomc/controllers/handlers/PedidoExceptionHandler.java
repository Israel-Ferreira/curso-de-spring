package io.codekaffee.cursomc.controllers.handlers;

import io.codekaffee.cursomc.exceptions.StandardError;
import io.codekaffee.cursomc.exceptions.nfex.PedidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class PedidoExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PedidoNotFoundException.class)
    public StandardError handlePedidoNotFoundException(PedidoNotFoundException exception){
        return new StandardError(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}
