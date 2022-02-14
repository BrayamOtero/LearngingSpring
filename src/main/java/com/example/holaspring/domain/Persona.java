package com.example.holaspring.domain;

import lombok.Data;

//Crea automaticamente los get, set y el contructor sin necesidad de escribirlo explicitamente
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
