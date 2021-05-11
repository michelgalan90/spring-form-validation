package com.galan.validando.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClienteValidadorRegex implements ConstraintValidator<ValidadorRegex, String> {
    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        if(valor.matches("[A-Z][\\d]{3}[-][A-Z]")){
            return true;
        }
        return false;
    }
}
