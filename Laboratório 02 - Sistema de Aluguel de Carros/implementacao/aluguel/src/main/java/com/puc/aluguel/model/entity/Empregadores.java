package com.puc.aluguel.model.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "empregadores")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Empregadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "nome")
    private String nome;


    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

}