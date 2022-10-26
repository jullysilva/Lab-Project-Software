package com.puc.vantagem.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BonificacaoDTO {

    private Integer custo;
    private String mensagem;
    private Long idProfessor;
    private Long idAluno;

}