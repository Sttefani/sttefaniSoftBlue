package com.sttefani.ribeiro.controllers;

import java.time.LocalDateTime;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;
import org.springframework.ui.Model;

public class ControllerHelper {

    
    public static void setEditMode(Model model, boolean isEdit){

        model.addAttribute("editMode", isEdit);

    }


}
