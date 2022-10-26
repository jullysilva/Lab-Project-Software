package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.model.dto.VantagemDTO.VantagemDTOBuilder;
import com.puc.vantagem.model.entity.Vantagem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T16:01:58-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
public class VantagemMapperImpl implements VantagemMapper {

    @Override
    public Vantagem dtoToEntity(VantagemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Vantagem vantagem = new Vantagem();

        vantagem.setCusto( dto.getCusto() );
        vantagem.setDescricao( dto.getDescricao() );
        vantagem.setId( dto.getId() );

        return vantagem;
    }

    @Override
    public VantagemDTO entityToDto(Vantagem entity) {
        if ( entity == null ) {
            return null;
        }

        VantagemDTOBuilder vantagemDTO = VantagemDTO.builder();

        vantagemDTO.custo( entity.getCusto() );
        vantagemDTO.descricao( entity.getDescricao() );
        vantagemDTO.id( entity.getId() );

        return vantagemDTO.build();
    }

    @Override
    public List<VantagemDTO> entityListToDtoList(List<Vantagem> entity) {
        if ( entity == null ) {
            return null;
        }

        List<VantagemDTO> list = new ArrayList<VantagemDTO>( entity.size() );
        for ( Vantagem vantagem : entity ) {
            list.add( entityToDto( vantagem ) );
        }

        return list;
    }
}
