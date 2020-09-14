package com.sttefani.ribeiro.enums;

public enum Cidade {

    ALTO_ALEGRE("Alto Alegre"), AMAJARI("Amajari"), BOA_VISTA("Boa Vista"), BONFIM("Bonfim"), CANTA("Cantá"), CARACARAI("Cacaracaí"), CAROEBE("Caroebe"), IRACEMA("Iracema"), MUCAJAI("Mucajaí"), NORMANDIA("Normandia"), PACARAIMA("Pacaraima"), RORAINOPOLIS("Rorainópolis"), SAO_JOAO_DA_BALIZA("São João da Baliza"), SAO_LUIZ_DO_ANAUA("São Luis do Anauá"), UIRAMUTA("Uiramuta");


    private String descricao;

    Cidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;

    }
}
