package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Perito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeritoRepository extends JpaRepository<Perito, Long> {

     Perito findByNome(String nome);

     List<Perito> findByNomeIgnoreCase(String nome);
}
