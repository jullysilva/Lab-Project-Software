package com.puc.aluguel.model.dto;


import com.puc.aluguel.model.enums.TipoRegistroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO {

    private Long id;
    private Double valor;
    private Integer parcela;
    private LocalDate dataInicioContrato;
    private LocalDate dataFimContrato;
    private TipoRegistroEnum tipoRegistroEnum;

}