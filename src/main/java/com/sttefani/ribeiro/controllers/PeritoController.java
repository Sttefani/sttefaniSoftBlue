package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.services.PeritoService;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
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
            try {
                peritoService.savePerito(perito);
                model.addAttribute("msg", "Perito cadastrado com sucesso!");
            } catch (ValidationException e) {
                errors.rejectValue("nome", null, e.getMessage());
            }
        }
        ControllerHelper.setEditMode(model, false);
        return "perito/cadastro";
    }
}