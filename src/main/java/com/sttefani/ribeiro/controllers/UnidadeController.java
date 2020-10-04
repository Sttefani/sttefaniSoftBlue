package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.services.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("unidades")
public class UnidadeController {

    public UnidadeController(UnidadeService unidadeService) {
    }
}
