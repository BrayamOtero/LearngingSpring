package com.example.holaspring.web;

import com.example.holaspring.domain.Persona;
import com.example.holaspring.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


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

    //Este metodo tambien actualiza si el idPersona es diferente de null
    //@Valid sirve para que valide el objeto persona y Errors es para saber si tiene errores
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errors){
        if(errors.hasErrors()){
            //con esto se despliega los errores en el formulario
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        //No es necesario set el idPersona del path variable porque Spring lo hace automaticamente.
        persona = personaService.encontarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    //Como metemos el parametro idPersona por el query parameter, no es necesario definirlo acá
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
