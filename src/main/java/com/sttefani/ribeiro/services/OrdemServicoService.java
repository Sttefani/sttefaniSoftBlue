package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Grupo;
import com.sttefani.ribeiro.models.OrdemServico;
import com.sttefani.ribeiro.repositories.OrdemServicoRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {


    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public void saveOrdemServico(OrdemServico ordemServico)  {
      ordemServicoRepository.save(ordemServico);
    }


}
