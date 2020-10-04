package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.GeneroOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroOcorrenciaRepository  extends JpaRepository<GeneroOcorrencia, Long> {
}
