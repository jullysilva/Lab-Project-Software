package com.puc.aluguel.mapper;

import com.puc.aluguel.model.dto.ClienteDTO;
import com.puc.aluguel.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO entityToDto(Cliente entity);

    Cliente dtoToEntity(ClienteDTO dto);
}
