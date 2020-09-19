package com.sttefani.ribeiro.models;

import com.sttefani.ribeiro.enums.SituacaoDaOcorrencia;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Historico implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SituacaoDaOcorrencia situacaoDaOcorrencia;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "historico_usuario", joinColumns = @JoinColumn(name = "historico_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuario = new ArrayList<>();

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntregaDoLaudo;

    @ManyToOne
    @JoinColumn(name = "ocorrencia_id", nullable = false)
    @NotBlank(message = "O código da  ocorrência a que se refere o histórico é obrigatório!")
    private Ocorrencia ocorrencia;

    private String UploadLaudo;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime remessa;

    private Integer OrdensServicosReiteradas;

    @Lob
    @Column(name = "notas_gerais", length = 512, nullable = false)
    @NotBlank(message = "Descreva algo sobre a movimentação da ocorrência!")
    private String notasGerais;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;


}
