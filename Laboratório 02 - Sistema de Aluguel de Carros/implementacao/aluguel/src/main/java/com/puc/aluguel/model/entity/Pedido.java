package com.puc.aluguel.model.entity;


import lombok.*;

import javax.persistence.*;

@Table(name = "pedido")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "concideracao_agente")
    private String concideracaoAgente;

    @Column(name = "parecer")
    private Boolean parecer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id", referencedColumnName = "id")
    private Agente agente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cidade_id", referencedColumnName = "id")
    private Automovel automovel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", referencedColumnName = "id")
    private Contrato contrato;

}