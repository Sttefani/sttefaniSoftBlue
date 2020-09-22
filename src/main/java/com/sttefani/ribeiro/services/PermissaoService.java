package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.models.Permissao;
import com.sttefani.ribeiro.repositories.PermissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;

    public PermissaoService(PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }

    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll();
    }
}
