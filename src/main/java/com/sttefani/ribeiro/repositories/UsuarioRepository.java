package com.sttefani.ribeiro.repositories;

import com.sttefani.ribeiro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

    public Usuario findByCpf(String cpf);

}
