package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {


    Grupo findByNome(String nome);
}
