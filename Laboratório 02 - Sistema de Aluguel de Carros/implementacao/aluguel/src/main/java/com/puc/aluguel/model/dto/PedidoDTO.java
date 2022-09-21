package com.puc.aluguel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private String id;
    private String concideracaoAgente;
    private Boolean parecer;
    private ClienteDTO cliente;
    private AgenteDTO agente;
    private AutomovelDTO automovel;
    private ContratoDTO contrato;

}