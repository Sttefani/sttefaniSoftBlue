package com.sttefani.ribeiro.embedded;

import com.sttefani.ribeiro.enums.Cidade;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;

@Embeddable
@Data
public class Endereco {

    @Pattern(regexp= "[0-9]{8}", message="O CEP possui formato inválido")
    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private Double longitude;

    private Double latitude;

    @Enumerated(EnumType.STRING)
    private Cidade cidade;


}
