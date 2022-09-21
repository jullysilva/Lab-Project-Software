package com.puc.aluguel.mapper;

import com.puc.aluguel.model.dto.ContratoDTO;
import com.puc.aluguel.model.entity.Contrato;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContratoMapper {

    ContratoMapper INSTANCE = Mappers.getMapper(ContratoMapper.class);

    ContratoDTO entityToDto(Contrato entity);

    Contrato dtoToEntity(ContratoDTO dto);
}
