package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Perito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeritoRepository extends JpaRepository<Perito, Long> {

    List<Perito> findByNomeContainingIgnoreCase(String nome);
}
