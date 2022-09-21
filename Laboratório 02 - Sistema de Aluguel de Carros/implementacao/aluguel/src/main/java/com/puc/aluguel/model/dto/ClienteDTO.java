package com.puc.aluguel.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.puc.aluguel.model.enums.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String cpf;
    private String rg;
    private String nome;
    private String endereco;
    private String email;
    private String senha;
    @JsonIgnore
    private TipoUsuarioEnum tipoUsuarioEnum;


}