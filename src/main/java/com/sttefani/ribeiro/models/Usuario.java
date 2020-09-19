package com.sttefani.ribeiro.models;

import com.sttefani.ribeiro.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome não pode ser vazio!")
    private String nome;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "O endereço de e-mail é obrigatório!")
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @CPF
    @Pattern(regexp = "[0-9]{11}", message = "O CPF possui formato inválido.")
    @NotBlank(message = "O CPF é obrigatório!")
    private String cpf;

    @Column(nullable = false, columnDefinition = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data de nascimento é obrigatória!")
    private LocalDate dataNascimento;

    @NotBlank(message = "O telefone de contato é obrigatório!")
    @Pattern(regexp = "[0-9]{10,11}", message = "O número de telefone possui formato inválido.")
    @Column(length = 11, nullable = false)
    private String celular;

    private String avatar;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Selecione um perfil!")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name="grupo_id", nullable = false)
    @NotBlank(message = "Selecione um grupo!")
    private Grupo grupo;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @ManyToMany(mappedBy = "usuario")
    private List<Historico> historicos;

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Ocorrencia> ocorrencia;

    public List<Ocorrencia> getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(List<Ocorrencia> ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    @ManyToMany(mappedBy = "usuario")
    private List<OrdemServico> ordemServicos;

    public List<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(List<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }
}
