package com.galan.validando.demo.validation;

import com.galan.validando.demo.models.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Controller
public class ClienteValidador implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Cliente.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Cliente cliente = (Cliente) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "clientevalidador.nombre");
/*
//comento esta parte porque voy a validar la identificacion usando anotacion ValidadorRegex
        if(!cliente.getIdentificacion().matches("[A-Z][\\d]{3}[-][A-Z]")){
            errors.rejectValue("identificacion", "clientevalidador.identificacion");
        }*/

    }
}
