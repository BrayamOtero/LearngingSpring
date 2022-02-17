package com.example.holaspring.service;

import com.example.holaspring.domain.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> listarPersonas();

    void guardar(Persona persona);
    void eliminar(Persona persona);

    Persona encontarPersona(Persona persona);
}
