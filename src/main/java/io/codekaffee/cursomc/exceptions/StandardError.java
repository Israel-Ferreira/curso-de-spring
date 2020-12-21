package io.codekaffee.cursomc.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class StandardError {
    private Integer status;
    private String message;
    private Instant moment;

    private List<String> details;


    public StandardError(String message, Integer status){
        this.status = status;
        this.message = message;
        this.moment = Instant.now();
    }


    public StandardError(String message, Integer status, List<String> details){
        this.message = message;
        this.status = status;
        this.details = details;
    }
}
