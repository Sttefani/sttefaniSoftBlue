package com.sttefani.ribeiro.models;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60, unique = true)
    @NotBlank(message = "O nome do grupo é obrigatório!")
    private String nome;

    @ManyToMany
    @JoinTable(name="GrupoPermissao", joinColumns=
            {@JoinColumn(name="grupo_id")}, inverseJoinColumns={@JoinColumn(name="permissao_id")})
    private List<Permissao> permissoes = new ArrayList<Permissao>();
}
