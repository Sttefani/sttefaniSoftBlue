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
public class Permissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "A descrição é obrigatória!")
    private String descricao;

    @ManyToMany(mappedBy="permissoes")
    private List<Grupo> grupo = new ArrayList<Grupo>();

}
