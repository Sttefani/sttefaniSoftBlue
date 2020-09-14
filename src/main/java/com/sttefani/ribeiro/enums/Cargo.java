package com.sttefani.ribeiro.enums;

public enum Cargo {

    DELEGADO("Delegado de Polícia"), JUIZ("Juiz de Direito"), DESEMBARGADOR("Desembargador"), PROMOTOR("Promotor"), PROCURADOR_DE_JUSTIÇA("Procurador do Ministério Público"), PROCURADOR_DO_ESTADO("Procurador do Estado"), ADVOGADO("Advogado"), PERITO("Perito"), CONSELHEIRO("Conselheiro"), OFICIAL_MILITAR("Oficial da Policial Militar"), OFICIAL_FA("Oficial das Forças Armadas"), CIOPS("Ciops"), OUTROS("outros");

    private final String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
