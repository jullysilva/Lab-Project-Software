package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.InstituicaoDTO;
import com.puc.vantagem.model.entity.Instituicao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstituicaoMapper {

    InstituicaoMapper INSTANCE = Mappers.getMapper(InstituicaoMapper.class);

    InstituicaoDTO entityToDto(Instituicao entity);

    Instituicao dtoToEntity(InstituicaoDTO dto);

}