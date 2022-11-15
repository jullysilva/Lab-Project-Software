package com.puc.vantagem.model.entity;

import lombok.*;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluno {

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
    private String rg;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "curso")
    private String curso;

    @Column(name = "moeda")
    private Integer moeda = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituicao_id", referencedColumnName = "id")
    private Instituicao instituicao;

    @ManyToMany
    List<Vantagem> vantagens;

}