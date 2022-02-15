package com.example.holaspring.dao;

import com.example.holaspring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//con CrudRepository no es necesario definir las funciones CRUD
// <Calse para hacer el crud, tipo de la clave primaria>
public interface PersonaDao extends JpaRepository<Persona, Long> {

}
