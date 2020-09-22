package com.sttefani.ribeiro.controllers;

import com.sttefani.ribeiro.models.Grupo;
import com.sttefani.ribeiro.repositories.GrupoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.List;

public class ControllerHelper {

    public static void setEditMode(Model model, boolean isEdit){

        model.addAttribute("editMode", isEdit);

    }

//    public static void addGruposToRequest(GrupoRepository grupoRepository, Model model){
//        List<Grupo> grupos = grupoRepository.findAll(Sort.by("nome"));
//        model.addAttribute("grupos", grupos);
//    }
}
