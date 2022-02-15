package com.example.holaspring.web;

import com.example.holaspring.dao.PersonaDao;
import com.example.holaspring.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControladorIncio {
    @Autowired
    public PersonaDao personaDao;

    @GetMapping("/")
    public String inicio(Model model){

        Iterable<Persona> personas = personaDao.findAll();
        model.addAttribute("personas", personas);
        return "index";
    }
}
