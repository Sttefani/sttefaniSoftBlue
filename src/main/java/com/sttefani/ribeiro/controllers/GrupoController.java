package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Grupo;
import com.sttefani.ribeiro.models.Permissao;
import com.sttefani.ribeiro.services.GrupoService;
import com.sttefani.ribeiro.services.PermissaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("grupos")
public class GrupoController {

    private final GrupoService grupoService;
    private final PermissaoService permissaoService;

    public GrupoController(GrupoService grupoService, PermissaoService permissaoService) {
        this.grupoService = grupoService;
        this.permissaoService = permissaoService;
    }

    @GetMapping("/new")
    public String newGrupo(Model model) {
        model.addAttribute("grupo", new Grupo());
        ControllerHelper.setEditMode(model, false);
        return "grupo/cadastro";
    }

    @PostMapping("/save")
    public String saveGrupo(@ModelAttribute("grupo") @Valid Grupo grupo, Errors errors, Model model) {

        if (!errors.hasErrors()) {
            try {
                grupoService.saveGrupo(grupo);
                model.addAttribute("msg", "Grupo cadastrado com sucesso!");
            } catch (ValidationException e) {
                errors.rejectValue("nome", null, e.getMessage());
            }
        }
        ControllerHelper.setEditMode(model, false);
        return "grupo/cadastro";

    }

    @ModelAttribute("permissoes")
    public List<Permissao> listaPermissoes() {
        return permissaoService.buscarTodos();
    }

}