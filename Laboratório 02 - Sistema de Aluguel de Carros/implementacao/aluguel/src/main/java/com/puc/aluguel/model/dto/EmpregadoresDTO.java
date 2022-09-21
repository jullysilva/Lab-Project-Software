package com.puc.aluguel.model.dto;

import com.puc.aluguel.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpregadoresDTO {

    private Double valor;
    private String nome;
    private Cliente cliente;
}