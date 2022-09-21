package com.puc.aluguel.model.entity;


import lombok.*;

import javax.persistence.*;

@Table(name = "automovel")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "placa")
    private String placa;

}