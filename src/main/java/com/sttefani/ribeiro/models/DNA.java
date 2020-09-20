package com.sttefani.ribeiro.models;

import com.sttefani.ribeiro.enums.Sexo;
import com.sttefani.ribeiro.enums.UnidadeFederativa;
import com.sttefani.ribeiro.enums.UnidadePrisional;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DNA implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 70)
    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @Column(nullable = true, length = 70)
    private String nomePai;

    @Column(nullable = false, length = 70)
    @NotBlank(message = "O nome da mãe é obrigatório!")
    private String nomeMae;

    private String foto;

    @NotBlank(message = "O local da coleta é obrigatório!")
    private String localDaColeta;

    @Column(nullable = false, length = 70)
    @NotBlank(message = "O local de nascimento é obrigatório!")
    private String naturalidade;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "A unidade federativa é obrigatório!")
    private UnidadeFederativa unidadeFederativa;

    @Column(nullable = false, columnDefinition = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data do nascimento é obrigatória!")
    private LocalDate dataNascimento;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotBlank(message = "A data e hora da coleta é obrigatória!")
    private LocalDateTime dataHoraDaColeta;

    @CPF
    @Column(nullable = false)
    @NotBlank(message = "O número do CPF é obrigatório!")
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Enumerated(EnumType.STRING)
    private UnidadePrisional unidadePrisional;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank(message = "O sexo é obrigatório!")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "dna_perito_id")
    private Perito perito;

    @Column(nullable = false, length = 60)
    @NotBlank(message = "O nome da testemunha é obrigatório!")
    private String testemunha;

    @Column(nullable = false)
    @NotBlank(message = "O tipo penal é obrigatório!")
    private String tipoPenal;

    @Column(columnDefinition = "boolean default false")
    private Boolean transfusionado;

    @Column(columnDefinition = "boolean default false")
    private Boolean gemeo;

    @Column(columnDefinition = "boolean default false")
    private Boolean transplantado;

    @Lob
    @Column(name = "notas_gerais", length = 512)
    private String notasGerais;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

}
