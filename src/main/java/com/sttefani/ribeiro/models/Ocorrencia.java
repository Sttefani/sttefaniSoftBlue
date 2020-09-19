package com.sttefani.ribeiro.models;

import com.sttefani.ribeiro.embedded.Endereco;
import com.sttefani.ribeiro.enums.Origem;
import com.sttefani.ribeiro.enums.Procedimento;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ocorrencia implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data da ocorrência é obrigatória!")
    private LocalDate dataOcorrencia;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotBlank(message = "A data dod registro da ocorrência é obrigatória!")
    private LocalDateTime dataHoraRegistroOcorrencia = LocalDateTime.now();

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
    @NotBlank(message = "Códio da espécie de ocorrência é obrigatório!")
    private EspecieOcorrencia especieOcorrencia;

    @ManyToOne
    @JoinColumn(name = "perito_id", nullable = false)
    @NotBlank(message = "A seleção de um perito para ocorrência é obrigatória!")
    private Perito perito;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Procedimento procedimento;

    @Column(length = 12)
    private String numeroDoProcedimento;

    @Column(length = 12)
    private String numeroDaRequisicao;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @ManyToOne
    @JoinColumn(name = "autoridade_id", nullable = false)
    @NotBlank(message = "A seleção de uma autoridade para ocorrência é obrigatória!")
    private Autoridade autoridade;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    @NotBlank(message = "A seleção de um setor para ocorrência é obrigatória!")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "unidade_id", nullable = false)
    @NotBlank(message = "A seleção de uma unidade para ocorrência é obrigatória!")
    private Unidade unidade;

    @Lob
    @Column(name = "notas_gerais", length = 512, nullable = false)
    @NotBlank(message = "A descrição da ocorrência é obrigatória!")
    private String notasGerais;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "ocorrencia", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Historico> historico;

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }

    @OneToMany(mappedBy = "ocorrencia", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<OrdemServico> ordemServico;

    public List<OrdemServico> getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(List<OrdemServico> ordemServico) {
        this.ordemServico = ordemServico;
    }
}
