package com.example.holaspring.dao;

import com.example.holaspring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    //Debe ser asi porque lo solicita spring security
    Usuario findByUsername(String username);
}
