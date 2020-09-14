package com.sttefani.ribeiro.enums;

public enum Origem {

    POLICIA_CIVIL("Polícia Civil"), CORREGEDORIA("Corregedoria de Polícia"), POLICIA_FEDERAL("Polícia Federal"), POLICIA_RODOVIARIA_FEDERAL("Polícia Rodoviária Federal"), POLICIA_MILITAR("Polícia Militar"), BOMBEIRO_MILITAR("Bombeiro Militar"), MINISTERIO_PUBLICO("Ministério Público"), PODER_JUDICIARIO("Poder Judiciário"), PODER_LEGISLATIVO("Poder Legislativo"), TRIBUNAL_DE_CONTAS("Tribunal de Contas"), OAB("OAB"), CIOPS("CIOPS"), OUTROS("outros");

    private String descricao;

    Origem(String descricao) {
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;

    }
}
