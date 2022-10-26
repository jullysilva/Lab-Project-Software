package com.puc.vantagem.model.dto;


import com.puc.vantagem.model.entity.Vantagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO extends UsuarioDTO {

    private String cpf;
    private String rg;
    private String endereco;
    private String curso;
    private Integer moeda;
    private Integer idInstituicao;
    private List<Vantagem> vantagens;

}