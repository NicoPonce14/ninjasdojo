package com.example.dojosninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String raiz(){
        return "redirect:/dojos";
    }
}
