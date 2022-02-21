package com.example.holaspring.web;

import com.example.holaspring.domain.Persona;
import com.example.holaspring.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControladorIncio {
    @Autowired
    public PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){

        Iterable<Persona> personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){

        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
}
