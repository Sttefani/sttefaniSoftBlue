package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.exceptions.ValidationException;
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

    public void saveGrupo(Grupo grupo) throws ValidationException {

        if (!validateGrupo(grupo.getNome(), grupo.getId())){
            throw new ValidationException("Já existe um grupo cadastrado com esse nome");
        }
        grupoRepository.save(grupo);
    }

    private boolean validateGrupo(String nome, Long id){
        Grupo grupo = grupoRepository.findByNome(nome);

        if (grupo != null){
            if (id == null){
                return false;
            }

            if(!grupo.getId().equals(id)){
                return false;
            }
        }

        return true;
    }

}
