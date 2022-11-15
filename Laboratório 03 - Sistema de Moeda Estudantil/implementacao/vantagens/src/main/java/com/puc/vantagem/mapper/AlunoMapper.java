package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.entity.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoDTO entityToDto(Aluno entity);

    Aluno dtoToEntity(AlunoDTO dto);

}