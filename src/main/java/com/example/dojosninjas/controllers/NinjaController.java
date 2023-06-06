package com.example.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosninjas.models.Ninja;
import com.example.dojosninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
    
    @Autowired
    private MainService serv;

    @GetMapping("/ninja/new")
    public String formNinja(@ModelAttribute("ninja") Ninja ninja, Model m) {
        m.addAttribute("dojos", serv.todosDojo());
        return "/ninjas/nuevoNinja.jsp";
    }

    @GetMapping("/pag/{pagNumber}")
    public String obtenerNinjaPorPag(Model m, @PathVariable("pagNumber") int pagNumber){
        Page<Ninja> ninjas = serv.ninjasPorPag(pagNumber-1);
        int totalPaginas = ninjas.getTotalPages();
        m.addAttribute("totalPages", totalPaginas);
        m.addAttribute("ninjas", ninjas);
        return "pagination.jsp";
    }

    @PostMapping("/ninja/new")
    public String nuevoNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult binding) {
        if (binding.hasErrors()) {
            return "/ninjas/nuevoNinja.jsp";
        } else {
            serv.crearNinja(ninja);
            return "redirect:/dojos";
        }
    }
}
