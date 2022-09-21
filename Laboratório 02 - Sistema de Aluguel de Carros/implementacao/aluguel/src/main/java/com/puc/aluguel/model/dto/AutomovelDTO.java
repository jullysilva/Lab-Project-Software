package com.puc.aluguel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelDTO {

    private String matricula;
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;

}