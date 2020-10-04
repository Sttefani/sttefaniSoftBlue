package com.sttefani.ribeiro.services;


import com.sttefani.ribeiro.exceptions.ValidationException;
import com.sttefani.ribeiro.models.Usuario;
import com.sttefani.ribeiro.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void saveUsuario(Usuario usuario) throws ValidationException {

        if (!validateUsuario(usuario.getNome(), usuario.getCpf(), usuario.getId())){
            throw new ValidationException("Já existe um usuario cadastrado com esse email ou cpf");
        }
        if (usuario.getId() != null){
            usuarioRepository.findById(usuario.getId()).orElseThrow();
            usuario.setSenha(usuario.getSenha());

        }else {
            usuario.encryptPassword();
        }

        usuarioRepository.save(usuario);
    }

    private boolean validateUsuario(String email, String cpf, Long id){
       Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null){
            if (id == null){
                return false;
            }

            if(!usuario.getId().equals(id)){
                return false;
            }
        }

        return true;
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> findByNomeContainingIgnoreCase(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }


    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
