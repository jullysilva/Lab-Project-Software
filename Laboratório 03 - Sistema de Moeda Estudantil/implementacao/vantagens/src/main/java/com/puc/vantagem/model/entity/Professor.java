package com.puc.vantagem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String departamento;

    @Column(name = "endereco")
    private Integer moeda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituicao_id", referencedColumnName = "id")
    private Instituicao instituicao;


}