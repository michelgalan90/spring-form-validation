package com.galan.validando.demo.models;

import com.galan.validando.demo.validation.ValidadorRegex;

import javax.validation.constraints.*;

public class Cliente {

   // @Pattern(regexp = "[A-Z][\\d]{3}[-][A-Z]")
    @ValidadorRegex
    private String identificacion;

    //@NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    @Email
    @NotEmpty
    private String email;

    @Min(18) @Max(35)
    @NotNull
    private Integer edad;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
