package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Perito;
import com.sttefani.ribeiro.repositories.PeritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeritoService {

    private final PeritoRepository peritoRepository;

    public PeritoService(PeritoRepository peritoRepository) {
        this.peritoRepository = peritoRepository;
    }

    public void savePerito(Perito perito) throws ValidationException {

        if (!validatePerito(perito.getNome(), perito.getId())){
            throw new ValidationException("Já existe um perito cadastrado com esse nome");
        }
        peritoRepository.save(perito);
    }

    private boolean validatePerito(String nome, Long id){
        Perito perito = peritoRepository.findByNome(nome);

        if (perito != null){
            if (id == null){
                return false;
            }

            if(!perito.getId().equals(id)){
                return false;
            }
        }

        return true;
    }

    public List<Perito> buscarTodos() {
       return peritoRepository.findAll();
    }

    public List<Perito> findByNomeContainingIgnoreCase(String nome) {
        return peritoRepository.findByNomeIgnoreCase(nome);
    }

    public Optional<Perito> buscarPorId(Long id) {
       return peritoRepository.findById(id);
    }

    public void excluir(Long id) {
        peritoRepository.deleteById(id);
    }
}
