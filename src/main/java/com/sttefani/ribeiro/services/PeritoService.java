package com.sttefani.ribeiro.services;

import com.sttefani.ribeiro.models.Perito;

import java.util.List;

public interface PeritoService {


    void salvar(Perito perito);

    void editar(Perito perito);

    void excluir(Long id) throws Exception;

    Perito buscarPorId(Long id) throws Exception;

    List<Perito> buscarTodos();

    List<Perito> findByNomeContainingIgnoreCase(String nome);

}
