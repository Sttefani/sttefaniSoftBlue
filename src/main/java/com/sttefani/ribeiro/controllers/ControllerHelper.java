package com.sttefani.ribeiro.controllers;

import org.springframework.ui.Model;

public class ControllerHelper {

    public static void setEditMode(Model model, boolean isEdit){

        model.addAttribute("editMode", isEdit);

    }
}
