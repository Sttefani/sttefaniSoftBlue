package com.sttefani.ribeiro.enums;

public enum Sexo {

    MASCULINO("Masculino"), FEMININO("Feminino"), OUTRO("Outro");

    private String descricao;


    Sexo(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
