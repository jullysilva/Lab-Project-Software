package com.puc.vantagem.mapper;

import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.entity.Aluno;
import com.puc.vantagem.model.entity.Vantagem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T16:01:58-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
public class AlunoMapperImpl implements AlunoMapper {

    @Override
    public AlunoDTO entityToDto(Aluno entity) {
        if ( entity == null ) {
            return null;
        }

        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setEmail( entity.getEmail() );
        alunoDTO.setId( entity.getId() );
        alunoDTO.setNome( entity.getNome() );
        alunoDTO.setSenha( entity.getSenha() );
        alunoDTO.setCpf( entity.getCpf() );
        alunoDTO.setCurso( entity.getCurso() );
        alunoDTO.setEndereco( entity.getEndereco() );
        alunoDTO.setMoeda( entity.getMoeda() );
        alunoDTO.setRg( entity.getRg() );
        List<Vantagem> list = entity.getVantagens();
        if ( list != null ) {
            alunoDTO.setVantagens( new ArrayList<Vantagem>( list ) );
        }

        return alunoDTO;
    }

    @Override
    public Aluno dtoToEntity(AlunoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setCpf( dto.getCpf() );
        aluno.setCurso( dto.getCurso() );
        aluno.setEmail( dto.getEmail() );
        aluno.setEndereco( dto.getEndereco() );
        aluno.setId( dto.getId() );
        aluno.setMoeda( dto.getMoeda() );
        aluno.setNome( dto.getNome() );
        aluno.setRg( dto.getRg() );
        aluno.setSenha( dto.getSenha() );
        List<Vantagem> list = dto.getVantagens();
        if ( list != null ) {
            aluno.setVantagens( new ArrayList<Vantagem>( list ) );
        }

        return aluno;
    }
}
