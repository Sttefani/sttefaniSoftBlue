package com.sttefani.ribeiro.enums;

public enum SituacaoDaOcorrencia {

    PROCESSAMENTO("Processamento"), FINALIZADA("Concluída e protocolada"), REMESSA("Remetida ao Cliente");

    private String descricao;

    SituacaoDaOcorrencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
