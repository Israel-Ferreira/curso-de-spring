package io.codekaffee.cursomc.controllers.handlers;

import io.codekaffee.cursomc.exceptions.StandardError;
import io.codekaffee.cursomc.exceptions.nfex.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientesExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<StandardError> handleClienteNotFoundException(ClienteNotFoundException ex){
        StandardError standardError = new StandardError(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(standardError);
    }
}
