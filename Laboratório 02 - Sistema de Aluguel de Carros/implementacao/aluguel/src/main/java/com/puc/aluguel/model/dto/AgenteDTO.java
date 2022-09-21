package com.puc.aluguel.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.puc.aluguel.model.enums.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenteDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    @JsonIgnore
    private TipoUsuarioEnum tipoUsuarioEnum;


}