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
@Table(name = "bonificacao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bonificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_aluno")
    private String idAluno;

    @Column(name = "id_professor")
    private String idProfessor;

    @Column(name = "custo")
    private Integer custo;

    @Column(name = "mensagem")
    private String mensagem;

}