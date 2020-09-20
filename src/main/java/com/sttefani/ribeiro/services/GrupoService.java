package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.models.Grupo;
import com.sttefani.ribeiro.repositories.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<Grupo> buscarTodos() {
        return grupoRepository.findAll();
    }
}
