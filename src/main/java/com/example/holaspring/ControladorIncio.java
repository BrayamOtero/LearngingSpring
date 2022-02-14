package com.example.holaspring;

import com.example.holaspring.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ControladorIncio {

    //Toma el valor definido en application.properties con la llave index.saludo
    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model){
        String mensaje = "Hola mundo con Thymeleaf";

        Persona persona = new Persona();
        persona.setNombre("Brayam");
        persona.setApellido("PErez");
        persona.setEmail("dfgf");
        persona.setTelefono("12457");

        Persona persona2 = new Persona();
        persona2.setNombre("Carla");
        persona2.setApellido("Gomezx");
        persona2.setEmail("uykkiu");
        persona2.setTelefono("096545");

        List<Persona> personas = Arrays.asList(persona, persona2);

        model   .addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);

//        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
