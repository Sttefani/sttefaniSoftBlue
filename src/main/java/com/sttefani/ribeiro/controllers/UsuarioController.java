package com.sttefani.ribeiro.controllers;


import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Grupo;
import com.sttefani.ribeiro.models.Usuario;
import com.sttefani.ribeiro.services.GrupoService;
import com.sttefani.ribeiro.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final GrupoService grupoService;

    private final UsuarioService usuarioService;

    public UsuarioController(GrupoService grupoService, UsuarioService usuarioService) {
        this.grupoService = grupoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/new")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        ControllerHelper.setEditMode(model, false);
        return "usuario/cadastro";
    }

    @PostMapping("/save")
    public String saveUsuario(@ModelAttribute("usuario") @Valid Usuario usuario,
                              Errors errors,  Model model){

        if (!errors.hasErrors()){
            try {
                usuarioService.saveUsuario(usuario);
                model.addAttribute("msg", "Usuário cadastrado com sucesso!");
            } catch (ValidationException e) {
                errors.rejectValue("nome", null, e.getMessage());
            }
        }
        ControllerHelper.setEditMode(model, false);
        return "usuario/cadastro";
    }
    @GetMapping("/listar")
    public String listar(@PathParam("pesquisa") String pesquisa, ModelMap model) {
        if (pesquisa == null || pesquisa.isEmpty()) {
            model.addAttribute("usuarios", usuarioService.buscarTodos());
        } else {
            model.addAttribute("usuarios", usuarioService.findByNomeContainingIgnoreCase(pesquisa));
        }
        return "usuario/lista";
    }

    @ModelAttribute("grupos")
    public List<Grupo> listaGrupos() {
        return grupoService.buscarTodos();
    }


}
