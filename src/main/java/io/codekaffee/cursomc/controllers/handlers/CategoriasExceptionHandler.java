package io.codekaffee.cursomc.controllers.handlers;

import io.codekaffee.cursomc.exceptions.StandardError;
import io.codekaffee.cursomc.exceptions.categoria.CategoriaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CategoriasExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoriaNotFoundException.class)
    public StandardError handleCategoriaNotFoundException(CategoriaNotFoundException ex){
        return new StandardError(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
    }


}
