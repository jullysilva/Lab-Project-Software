package com.puc.vantagem.model.dto;


import com.puc.vantagem.model.enums.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;

}