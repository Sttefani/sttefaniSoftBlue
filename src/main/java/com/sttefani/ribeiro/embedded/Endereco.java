package com.sttefani.ribeiro.embedded;

import com.sttefani.ribeiro.enums.Cidade;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Data
public class Endereco {

    @Column(name = "endereco_cep")
    @Pattern(regexp= "[0-9]{8}", message="O CEP possui formato inválido")
    private String cep;

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private String numero;

    private String complemento;

    @Column(name = "endereco_bairro")
    private String bairro;

    @Column(name = "endereco_longitude")
    private Double longitude;

    @Column(name = "endereco_latitude")
    private Double latitude;

    @Enumerated(EnumType.STRING)
    private Cidade cidade;


}
