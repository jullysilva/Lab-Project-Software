package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.model.entity.Aluno;
import com.puc.vantagem.model.entity.Vantagem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VantagemMapper {

    VantagemMapper INSTANCE = Mappers.getMapper(VantagemMapper.class);

    Vantagem dtoToEntity(VantagemDTO dto);

    VantagemDTO entityToDto(Vantagem entity);

    List<VantagemDTO> entityListToDtoList(List<Vantagem> entity);


}