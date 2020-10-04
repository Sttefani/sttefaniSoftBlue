package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<Dna, Long> {
}
