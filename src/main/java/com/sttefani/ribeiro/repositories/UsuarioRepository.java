package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByCpf(String cpf);

    List<Usuario> findByNomeContainingIgnoreCase(String nome);

}
