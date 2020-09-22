package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.services.PeritoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

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
    @GetMapping("/listar")
    public String listar(@PathParam("pesquisa") String pesquisa, Model model) {
        if (pesquisa == null || pesquisa.isEmpty()) {
            model.addAttribute("peritos", peritoService.buscarTodos());
        } else {
            model.addAttribute("peritos", peritoService.findByNomeContainingIgnoreCase(pesquisa));
        }
        ControllerHelper.setEditMode(model, false);
        return "perito/lista";
    }
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("perito", peritoService.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ControllerHelper.setEditMode(model, false);
        return "perito/show";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        peritoService.excluir(id);
        attr.addFlashAttribute("success", "Perito excluído com sucesso.");
        return "redirect:/peritos/listar";
    }

    @ModelAttribute ("peritos")
    public List<Perito> listaDePeritos() {
        return peritoService.buscarTodos();
    }

}