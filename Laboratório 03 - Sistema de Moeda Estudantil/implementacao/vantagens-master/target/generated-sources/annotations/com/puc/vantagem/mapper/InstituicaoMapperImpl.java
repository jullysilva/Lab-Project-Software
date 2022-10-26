package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.InstituicaoDTO;
import com.puc.vantagem.model.dto.InstituicaoDTO.InstituicaoDTOBuilder;
import com.puc.vantagem.model.entity.Instituicao;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T16:01:58-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
public class InstituicaoMapperImpl implements InstituicaoMapper {

    @Override
    public InstituicaoDTO entityToDto(Instituicao entity) {
        if ( entity == null ) {
            return null;
        }

        InstituicaoDTOBuilder instituicaoDTO = InstituicaoDTO.builder();

        instituicaoDTO.id( entity.getId() );
        instituicaoDTO.nome( entity.getNome() );

        return instituicaoDTO.build();
    }

    @Override
    public Instituicao dtoToEntity(InstituicaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Instituicao instituicao = new Instituicao();

        instituicao.setId( dto.getId() );
        instituicao.setNome( dto.getNome() );

        return instituicao;
    }
}
