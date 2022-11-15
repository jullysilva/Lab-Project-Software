package com.puc.vantagem.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO extends UsuarioDTO {

    private Integer idInstituicao;
    private String cpf;
    private String departamento;
    private Integer moeda;

}