package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Perito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeritoRepository extends JpaRepository<Perito, Long> {

    public Perito findByNome(String nome);

}
