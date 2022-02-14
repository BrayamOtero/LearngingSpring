package com.example.holaspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorIncio {
    @GetMapping("/")
    public String inicio(){
        return "Hola Mundo con Spring 2";
    }
}
