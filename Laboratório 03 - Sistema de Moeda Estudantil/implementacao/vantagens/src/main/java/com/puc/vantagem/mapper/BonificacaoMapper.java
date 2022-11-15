package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.BonificacaoDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.model.entity.Bonificacao;
import com.puc.vantagem.model.entity.Vantagem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BonificacaoMapper {

    BonificacaoMapper INSTANCE = Mappers.getMapper(BonificacaoMapper.class);

    Bonificacao dtoToEntity(BonificacaoDTO dto);

    BonificacaoDTO entityToDto(Bonificacao entity);

    List<BonificacaoDTO> entityToDto(List<Bonificacao> entity);


}