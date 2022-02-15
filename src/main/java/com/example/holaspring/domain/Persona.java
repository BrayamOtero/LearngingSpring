package com.example.holaspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//Crea automaticamente los get, set y el contructor sin necesidad de escribirlo explicitamente
@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
