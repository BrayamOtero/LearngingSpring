package com.example.holaspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControladorIncio {
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
}
