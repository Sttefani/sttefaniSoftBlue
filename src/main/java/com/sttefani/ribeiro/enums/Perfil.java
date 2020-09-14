package com.sttefani.ribeiro.enums;

public enum Perfil {

    ADMINISTRADOR("Administrador"), PERITO("Perito"), ADMINISTRATIVO("Administrativo"), CLIENTE("Cliente");


    private String descricao;

    private Perfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
