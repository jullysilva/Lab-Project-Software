package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.ProfessorDTO;
import com.puc.vantagem.model.entity.Professor;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T16:01:58-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
public class ProfessorMapperImpl implements ProfessorMapper {

    @Override
    public ProfessorDTO entityToDto(Professor entity) {
        if ( entity == null ) {
            return null;
        }

        ProfessorDTO professorDTO = new ProfessorDTO();

        professorDTO.setEmail( entity.getEmail() );
        professorDTO.setId( entity.getId() );
        professorDTO.setNome( entity.getNome() );
        professorDTO.setSenha( entity.getSenha() );
        professorDTO.setCpf( entity.getCpf() );
        professorDTO.setDepartamento( entity.getDepartamento() );
        professorDTO.setMoeda( entity.getMoeda() );

        return professorDTO;
    }

    @Override
    public Professor dtoToEntity(ProfessorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setCpf( dto.getCpf() );
        professor.setDepartamento( dto.getDepartamento() );
        professor.setEmail( dto.getEmail() );
        professor.setId( dto.getId() );
        professor.setMoeda( dto.getMoeda() );
        professor.setNome( dto.getNome() );
        professor.setSenha( dto.getSenha() );

        return professor;
    }
}
