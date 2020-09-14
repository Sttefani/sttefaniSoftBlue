package com.sttefani.ribeiro.enums;

public enum Procedimento {

    APFD("Auto de Prisão em Flagrante Delito"), IP("Inquérito Policial"), IPM("Inquérito Policial Militar"), PROCESSO_CIVIL("Processo Civil"), PROCESSO_PENAL("Processo Penal"), PAD("Processo Administrativo"), SINDICANCIA("Sindicância"), TCO("Termo Circunstanciado de Ocorrência"), BO("Boletim de Ocorrência"), AAFAI("Auto de Apreensão em Flagrante de Ato Infracional"), VPI("Verificação Preliminar de Inquérito"), Outros("Outros");

    private String descricao;


    Procedimento(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
