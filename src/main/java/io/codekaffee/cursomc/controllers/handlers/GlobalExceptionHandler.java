package io.codekaffee.cursomc.controllers.handlers;

import io.codekaffee.cursomc.exceptions.StandardError;
import io.codekaffee.cursomc.exceptions.nfex.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e){
        StandardError standardError = new StandardError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(standardError);
    }
}
