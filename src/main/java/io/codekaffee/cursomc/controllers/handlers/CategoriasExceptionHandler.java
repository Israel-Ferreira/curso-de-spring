package io.codekaffee.cursomc.controllers.handlers;

import io.codekaffee.cursomc.exceptions.DataIntegrityException;
import io.codekaffee.cursomc.exceptions.StandardError;
import io.codekaffee.cursomc.exceptions.nfex.CategoriaNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class CategoriasExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoriaNotFoundException.class)
    public StandardError handleCategoriaNotFoundException(CategoriaNotFoundException ex){
        return new StandardError(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityException.class)
    public StandardError handleDataIntegrityViolationEx(DataIntegrityException exception){
        return new StandardError(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
    }

}
