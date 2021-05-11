package com.galan.validando.demo.controllers;

import com.galan.validando.demo.models.Cliente;
import com.galan.validando.demo.validation.ClienteValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    private ClienteValidador validador;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validador);
    }

    @GetMapping("/form")
    public String form(Model model){
        Cliente cliente = new Cliente();
        cliente.setIdentificacion("A123-B");
        model.addAttribute("titulo", "Llenando el formulario");
        model.addAttribute("cliente", cliente);
        return "form";
    }

    @PostMapping("/form")
    public String getForm(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus sessionStatus){
        model.addAttribute("titulo", "Mostrando resultado de formulario");

      //  validador.validate(cliente, result); //esta linea se sustituye con el @InitBinder

        if(result.hasErrors()){
          /*  Map<String, String> errors = new HashMap<>();

            result.getFieldErrors().forEach(fieldError -> {
                errors.put(fieldError.getField(), "Error en campo "
                        .concat(fieldError.getField()).concat(": ")
                        .concat(fieldError.getDefaultMessage()));
            });
            model.addAttribute("errors", errors);*/
            return "form";
        }

        model.addAttribute("cliente", cliente);
        sessionStatus.setComplete();
        return "resultado";
    }
}
