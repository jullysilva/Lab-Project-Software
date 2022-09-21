package com.puc.aluguel.mapper;

import com.puc.aluguel.model.dto.AgenteDTO;
import com.puc.aluguel.model.entity.Agente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgenteMapper {

    AgenteMapper INSTANCE = Mappers.getMapper(AgenteMapper.class);

    AgenteDTO entityToDto(Agente entity);

    Agente dtoToEntity(AgenteDTO dto);
}
