package com.puc.aluguel.model.entity;


import com.puc.aluguel.model.enums.TipoUsuarioEnum;
import lombok.*;

import javax.persistence.*;

@Table(name = "agente")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Agente {

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

    @Column(name = "tipo_usuario")
    private TipoUsuarioEnum tipoUsuarioEnum;
}