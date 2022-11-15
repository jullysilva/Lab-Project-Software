package com.puc.vantagem.services;

import com.puc.vantagem.mapper.AlunoMapper;
import com.puc.vantagem.mapper.InstituicaoMapper;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.InstituicaoDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.repository.AlunoRepository;
import com.puc.vantagem.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {

    @Autowired
    InstituicaoRepository repository;

    public InstituicaoDTO criarInstituicao(InstituicaoDTO instituicaoDTO) {
        var aluno = repository.save(InstituicaoMapper.INSTANCE.dtoToEntity(instituicaoDTO));
        return InstituicaoMapper.INSTANCE.entityToDto(aluno);
    }

}