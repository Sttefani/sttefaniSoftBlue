package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.services.PeritoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peritos")
public class PeritoController {

    private final PeritoService peritoService;

    public PeritoController(PeritoService peritoService) {
        this.peritoService = peritoService;
    }

    @GetMapping("/new")
    public String newPerito(Model model){
        model.addAttribute("perito", new Perito());
        ControllerHelper.setEditMode(model, false);
        return "perito/cadastro";
    }

    @PostMapping("/save")
    public String savePerito(@ModelAttribute ("perito") @Valid Perito perito,
        Errors errors, Model model){

        if (!errors.hasErrors()){
            peritoService.savePerito(perito);
            model.addAttribute("msg", "Perito cadastrado com sucesso!");
        }
        ControllerHelper.setEditMode(model, false);
        return "perito/cadastro";
    }
}