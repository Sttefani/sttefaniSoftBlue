package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.repositories.EspecieOcorrenciaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("especieOcorrencias")
public class EspecieOcorrenciaController {

    @SuppressWarnings("unused")
	private final EspecieOcorrenciaRepository especieOcorrenciaRepository;

    public EspecieOcorrenciaController(EspecieOcorrenciaRepository especieOcorrenciaRepository) {
        this.especieOcorrenciaRepository = especieOcorrenciaRepository;
    }
}
