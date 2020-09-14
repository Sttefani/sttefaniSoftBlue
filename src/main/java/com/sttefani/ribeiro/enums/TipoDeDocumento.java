package com.sttefani.ribeiro.enums;

public enum TipoDeDocumento {

    OFICIO("Ofício"), MEMORANDO("Memo"), ORDEMJUDICIAL("Ordem Judicial"), REQUISICAO("Requisição"), ORDEM_DE_SERVICO("Ordem de Serviço"), DESPACHO("Despacho"), RELATÓRIO("Relatório"), CARTA("Carta"), REQUERIMENTO("Requerimento"), ATESTADO("Atestado"), CERTIDAO("Certidão"), CIRCULAR("Circular"), CONTRATO("Contrato"), CONVENIO("Convênio"), DECLARACAO("Declaração"), EXPOSICAO_DE_MOTIVOS("Exposição de Motivos"), PARECER("Parecer"), PORTARIA("Portaria"), RESOLUCAO("Resolução"), NOTA("Nota"), ATA("Ata"), CONVITE("Convite"), OUTROS("Outros");


    private String descricao;

    private TipoDeDocumento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
