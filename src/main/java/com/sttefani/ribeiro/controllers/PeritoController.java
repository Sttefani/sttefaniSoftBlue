package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.services.PeritoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/peritos")
public class PeritoController {

    private final PeritoService service;

    public PeritoController(PeritoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public String listar(@PathParam("pesquisa") String pesquisa, ModelMap model) {
        if (pesquisa == null || pesquisa.isEmpty()) {
            model.addAttribute("peritos", service.buscarTodos());
        } else {
            model.addAttribute("peritos", service.findByNomeContainingIgnoreCase(pesquisa));
        }
        return "perito/lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Perito perito) {
        return "perito/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Perito perito, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "perito/cadastro";
        }
        service.salvar(perito);
        attr.addFlashAttribute("success", "Perito cadastrado com sucesso.");
        return "redirect:/peritos/listar";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model) {
        try {
            model.addAttribute("perito", service.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "perito/show";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        try {
            model.addAttribute("perito", service.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "perito/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Perito perito, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "perito/cadastro";
        }

        service.editar(perito);
        attr.addFlashAttribute("success", "Cadastro atualizado com sucesso.");
        return "redirect:/peritos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        try {
            service.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        attr.addFlashAttribute("success", "Perito excluído com sucesso.");
        return "redirect:/peritos/listar";
    }

    @ModelAttribute("peritos")
    public List<Perito> listaDePeritos() {
        return service.buscarTodos();
    }
}