package io.codekaffee.cursomc.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ValidationError  extends StandardError{
    private List<FieldMessage> fields = new ArrayList<>();

    public ValidationError(String message, Integer status) {
        super(message, status);
    }

    public ValidationError(String message, Integer status, List<FieldMessage> fields) {
        super(message, status);
        this.fields = fields;
    }

    public void addError(String fieldName, String message){
        fields.add(new FieldMessage(fieldName, message));
    }
}
