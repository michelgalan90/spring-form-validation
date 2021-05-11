package com.galan.validando.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ClienteValidadorRegex.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidadorRegex {
    String message() default "El patron del identificador no parece estar bacano arreglalo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
