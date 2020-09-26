package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}
