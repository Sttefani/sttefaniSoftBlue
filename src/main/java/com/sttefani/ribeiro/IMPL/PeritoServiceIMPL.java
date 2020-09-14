package com.sttefani.ribeiro.IMPL;

import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.repositories.PeritoRepository;
import com.sttefani.ribeiro.services.PeritoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeritoServiceIMPL implements PeritoService {

    private final PeritoRepository repository;

    public PeritoServiceIMPL(PeritoRepository repository) {
        this.repository = repository;
    }


    @Override
    public void salvar(Perito perito) {
        repository.save(perito);

    }

    @Override
    public void editar(Perito perito) {
        repository.save(perito);
    }

    @Override
    public void excluir(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Perito buscarPorId(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Perito não encontrado"));
    }

    @Override
    public List<Perito> buscarTodos() {
        return repository.findAll();

    }

    @Override
    public List<Perito> findByNomeContainingIgnoreCase(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}
