package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.repositories.SetorRepository;
import org.springframework.stereotype.Service;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }
}
