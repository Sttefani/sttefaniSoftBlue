package com.sttefani.ribeiro.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.joda.time.LocalDateTime;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sttefani.ribeiro.models.Ocorrencia;
import com.sttefani.ribeiro.models.OrdemServico;
import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.models.Usuario;
import com.sttefani.ribeiro.repositories.OcorrenciaRepository;
import com.sttefani.ribeiro.repositories.PeritoRepository;
import com.sttefani.ribeiro.repositories.UsuarioRepository;
import com.sttefani.ribeiro.services.OrdemServicoService;

@Controller
@RequestMapping("ordemServicos")
public class OrdemServicoController {

    private final UsuarioRepository usuarioRepository;

    private final PeritoRepository peritoRepository;

    private final OrdemServicoService ordemServicoService;

    private final OcorrenciaRepository ocorrenciaRepository;

    public OrdemServicoController(UsuarioRepository usuarioRepository, PeritoRepository peritoRepository, OrdemServicoService ordemServicoService, OcorrenciaRepository ocorrenciaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.peritoRepository = peritoRepository;
        this.ordemServicoService = ordemServicoService;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @GetMapping("/new")
    public String newOrdemServico(Model model) {
        model.addAttribute("ordemServico", new OrdemServico());
        ControllerHelper.setEditMode(model, false);
        return "ordemServico/cadastro";
    }

    @PostMapping("/save")
    public String saveOrdemServico(@ModelAttribute("ordemServico") @Valid OrdemServico ordemServico, Errors errors, Model model) {

        if (!errors.hasErrors()) {
            ordemServicoService.saveOrdemServico(ordemServico);
            model.addAttribute("msg", "Ordem de Serviço cadastrada com sucesso!");
        }
        ControllerHelper.setEditMode(model, false);
        return "ordemServico/cadastro";

    }
    @GetMapping("/listar")
    public String listar(@PathParam("pesquisa") String pesquisa, Model model) {
        if (pesquisa == null || pesquisa.isEmpty()) {
            model.addAttribute("ordemServico", ordemServicoService.buscarTodos());
        }
        ControllerHelper.setEditMode(model, false);
        return "ordemServico/lista";
    }
    @GetMapping("/show/{id}")
    @PreAuthorize("hasRole({'ADMINISTRADOR', 'GERENTE'})")
    public String show(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("ordemServico", ordemServicoService.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ControllerHelper.setEditMode(model, true);
        return "ordemServico/show";
    }
    @GetMapping("/excluir/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        ordemServicoService.excluir(id);
        attr.addFlashAttribute("success", "OS excluída com sucesso.");
        return "redirect:/ordemServicos/listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @ModelAttribute("peritos")
    public List<Perito> listaPeritos() {
       return peritoRepository.findAll();
    }

    @ModelAttribute("ocorrencias")
    public List<Ocorrencia> listaOcorrencias() {
        return ocorrenciaRepository.findAll();
    }


}

