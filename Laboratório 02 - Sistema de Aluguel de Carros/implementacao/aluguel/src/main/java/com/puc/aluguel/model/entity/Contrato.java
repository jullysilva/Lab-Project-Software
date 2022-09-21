package com.puc.aluguel.model.entity;


import com.puc.aluguel.model.enums.TipoRegistroEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "contrato")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "parcela")
    private Integer parcela;

    @Column(name = "dataInicioContrato")
    private LocalDate dataInicioContrato;

    @Column(name = "dataFimContrato")
    private LocalDate dataFimContrato;

    @Column(name = "tipoRegistroEnum")
    private TipoRegistroEnum tipoRegistroEnum;

}