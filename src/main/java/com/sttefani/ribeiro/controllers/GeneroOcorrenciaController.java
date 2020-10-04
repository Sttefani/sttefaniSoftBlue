package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.services.GeneroOcorrenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("generoOcorrencias")
public class GeneroOcorrenciaController {

    @SuppressWarnings("unused")
	private final GeneroOcorrenciaService generoOcorrenciaService;

    public GeneroOcorrenciaController(GeneroOcorrenciaService generoOcorrenciaService) {
        this.generoOcorrenciaService = generoOcorrenciaService;
    }
}
