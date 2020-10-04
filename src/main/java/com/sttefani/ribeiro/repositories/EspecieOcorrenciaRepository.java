package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.EspecieOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieOcorrenciaRepository extends JpaRepository<EspecieOcorrencia, Long> {
}
