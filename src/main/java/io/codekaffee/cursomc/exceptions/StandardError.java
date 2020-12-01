package io.codekaffee.cursomc.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StandardError {
    private Integer status;
    private String message;
    private Instant moment;


    public StandardError(String message, Integer status){
        this.status = status;
        this.message = message;
        this.moment = Instant.now();
    }
}
