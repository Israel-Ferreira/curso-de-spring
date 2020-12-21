package io.codekaffee.cursomc.controllers.handlers;

import io.codekaffee.cursomc.exceptions.StandardError;
import io.codekaffee.cursomc.exceptions.nfex.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e){
        StandardError standardError = new StandardError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(standardError);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> handleValidationErrors(ConstraintViolationException ex){
        StandardError standardError = new StandardError(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValidExc(MethodArgumentNotValidException exc){
        List<String> details =  exc.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        StandardError standardError = new StandardError("Erro de Validação", HttpStatus.BAD_REQUEST.value(), details);
        return ResponseEntity.ok(standardError);
    }

}
