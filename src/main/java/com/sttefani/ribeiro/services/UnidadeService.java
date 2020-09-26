package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }
}
