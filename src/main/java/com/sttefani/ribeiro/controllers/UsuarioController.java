package com.sttefani.ribeiro.controllers;


import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Grupo;
import com.sttefani.ribeiro.models.Usuario;
import com.sttefani.ribeiro.repositories.GrupoRepository;
import com.sttefani.ribeiro.services.GrupoService;
import com.sttefani.ribeiro.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final GrupoService grupoService;

    private final UsuarioService usuarioService;


    public UsuarioController(GrupoService grupoService, UsuarioService usuarioService, GrupoRepository grupoRepository) {
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
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("usuario", usuarioService.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ControllerHelper.setEditMode(model, false);
        return "usuario/show";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        usuarioService.excluir(id);
        attr.addFlashAttribute("success", "Usuário excluído com sucesso.");
        return "redirect:/usuarios/listar";
    }

    @ModelAttribute("grupos")
    public List<Grupo> listaGrupos() {
        return grupoService.buscarTodos();
    }


}
