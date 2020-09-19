package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.repositories.PeritoRepository;
import org.springframework.stereotype.Service;

@Service
public class PeritoService {

    private final PeritoRepository peritoRepository;

    public PeritoService(PeritoRepository peritoRepository) {
        this.peritoRepository = peritoRepository;
    }

    public void savePerito(Perito perito){
        peritoRepository.save(perito);
    }
}
