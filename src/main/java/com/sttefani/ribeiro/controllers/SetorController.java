package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.services.SetorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("setores")
public class SetorController {

    @SuppressWarnings("unused")
	private final SetorService setorService;


    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }
}
