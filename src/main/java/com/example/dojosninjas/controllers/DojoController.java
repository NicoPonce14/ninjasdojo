package com.example.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosninjas.models.Dojo;
import com.example.dojosninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

    @Autowired
    private MainService serv;

    @GetMapping("/dojos")
    public String index(Model m) {
        m.addAttribute("dojos", serv.todosDojo());
        return "/index.jsp";
    }

    @GetMapping("/dojos/new")
    public String formDojo(@ModelAttribute("dojos") Dojo dojo, Model m) {
        return "dojos/nuevoDojo.jsp";
    }

    @PostMapping("/dojos/new")
    public String nuevoDojo(@Valid @ModelAttribute("dojos") Dojo dojo, BindingResult binding) {
        if (binding.hasErrors()) {
            return "/dojos/nuevoDojo.jsp";
        } else {
            serv.crearDojo(dojo);
            return "redirect:/dojos";
        }
    }

    @GetMapping("/dojos/{id}")
    public String dojosYninjas(@PathVariable("id") Long id,Model m){
        m.addAttribute("dojosyninjas", serv.showDojo(id));
        return "/dojos/mostrarDojo.jsp";
    }
}
