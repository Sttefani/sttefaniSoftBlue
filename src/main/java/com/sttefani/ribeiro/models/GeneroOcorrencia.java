package com.sttefani.ribeiro.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GeneroOcorrencia implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    @NotBlank(message = "O do número código é obrigatório!")
    private String codigo;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "A descrição do gênero da ocorrência é obrigatório!")
    private String descricao;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "generoOcorrencia", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<EspecieOcorrencia> especieOcorrencia;

    public List<EspecieOcorrencia> getEspecieOcorrencia() {
        return especieOcorrencia;
    }

    public void setEspecieOcorrencia(List<EspecieOcorrencia> especieOcorrencia) {
        this.especieOcorrencia = especieOcorrencia;
    }
}
