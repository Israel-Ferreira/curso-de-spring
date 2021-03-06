package io.codekaffee.cursomc.annotations;

import io.codekaffee.cursomc.validations.ClientUpdateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClientUpdateValidator.class)
public @interface ClientUpdate {
    String message() default "Erro de Validação";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
