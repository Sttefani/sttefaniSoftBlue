package com.sttefani.ribeiro.enums;

public enum UnidadePrisional {

    PAMC("PAMC"), CADEIA_PUBLICA("Cadéia Pública"), CADEIA_FEMININA("Cadéia Feminina"), SAO_LUIS("Presídio de São Luis do Anauá"), RORANOPOLIS("Presídio de Rorainópolis"), ESTADO_MAIOR("Estado Maior"), DELEGACIAS("Distritos Policiais"), CENTRO_TRIAGEM_PRISIONAL("Unidade de Triagem"), OUTRO("Outros");

    private String descricao;


    UnidadePrisional(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
