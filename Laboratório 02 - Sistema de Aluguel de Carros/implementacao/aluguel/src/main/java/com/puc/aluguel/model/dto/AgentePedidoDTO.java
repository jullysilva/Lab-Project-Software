package com.puc.aluguel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentePedidoDTO {


    private Long id;
    private Long idAgente;
    private String concideracao;
    private Boolean parecer;
    private String email;
    private String senha;
}