package com.example.holaspring;

import com.example.holaspring.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        model   .addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);

        model.addAttribute("persona", persona);
        return "index";
    }
}
