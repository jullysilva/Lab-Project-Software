package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.ProfessorDTO;

import com.puc.vantagem.model.entity.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {

    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    ProfessorDTO entityToDto(Professor entity);

    Professor dtoToEntity(ProfessorDTO dto);

}