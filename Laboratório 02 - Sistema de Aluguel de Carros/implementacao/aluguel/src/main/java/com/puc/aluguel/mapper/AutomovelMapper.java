package com.puc.aluguel.mapper;

import com.puc.aluguel.model.dto.AutomovelDTO;
import com.puc.aluguel.model.entity.Automovel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AutomovelMapper {

    AutomovelMapper INSTANCE = Mappers.getMapper(AutomovelMapper.class);

    AutomovelDTO entityToDto(Automovel entity);

    Automovel dtoToEntity(AutomovelDTO dto);

    List<AutomovelDTO> entityToDto(List<Automovel> entity);


    List<Automovel> dtoToEntity(List<AutomovelDTO> dto);
}
