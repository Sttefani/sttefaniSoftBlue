package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.models.OrdemServico;
import com.sttefani.ribeiro.repositories.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {


    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public void saveOrdemServico(OrdemServico ordemServico)  {
      ordemServicoRepository.save(ordemServico);
    }

    public List<OrdemServico> buscarTodos() {
        return ordemServicoRepository.findAll();
    }


    public Optional<OrdemServico> buscarPorId(Long id) {
        return ordemServicoRepository.findById(id);
    }

    public void excluir(Long id) {
        ordemServicoRepository.deleteById(id);
    }



}
