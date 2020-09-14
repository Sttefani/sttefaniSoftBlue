package com.sttefani.ribeiro.models;

import com.sttefani.ribeiro.embedded.Endereco;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Unidade implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String nome;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Embedded
    private Endereco endereco;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "unidade", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Ocorrencia> ocorrencia;

    public List<Ocorrencia> getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(List<Ocorrencia> ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}
