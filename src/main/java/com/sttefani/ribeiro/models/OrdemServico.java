package com.sttefani.ribeiro.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrdemServico implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "ordem_servico_usuario", joinColumns = @JoinColumn(name = "ordem_servico_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuario = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "perito_id", nullable = false)
    @NotBlank(message = "A seleção de um perito para OS é obrigatória!")
    private Perito perito;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataDaOrdemDeServico = LocalDateTime.now();

    @Column(nullable = false)
    @NotBlank(message = "O prazo é obrigatório!")
    private Integer prazoEmDias;

    @Column(nullable = false, length = 2)
    @NotBlank(message = "Informação obrigatória!")
    private Integer quantidadeDeReiteracoes;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataDoVencimento;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataDoRecebimentoDaOrdemDeServico;

    @Column(nullable = false, columnDefinition = "datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataDaBaixa;

    @ManyToOne
    @JoinColumn(name = "ocorrencia_id", nullable = false)
    private Ocorrencia ocorrencia;

    @Size(max=100)
    private String uploadRequisicao;

    private transient MultipartFile uploadRequisicaoFile;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @Lob
    @Column(name = "notas_gerais", length = 512, nullable = false)
    private String notasGerais;

}
