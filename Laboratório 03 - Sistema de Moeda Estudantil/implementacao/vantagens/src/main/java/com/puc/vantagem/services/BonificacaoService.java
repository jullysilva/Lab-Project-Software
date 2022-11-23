package com.puc.vantagem.services;

import com.puc.vantagem.mapper.BonificacaoMapper;
import com.puc.vantagem.mapper.VantagemMapper;
import com.puc.vantagem.model.dto.BonificacaoDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.repository.BonificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class BonificacaoService {

    @Autowired
    BonificacaoRepository repository;

    public void salvarBonificacao(BonificacaoDTO bonificacaoDTO) {
        repository.save(BonificacaoMapper.INSTANCE.dtoToEntity(bonificacaoDTO));
    }

    public List<BonificacaoDTO> consultarBonificacoes() {
        return BonificacaoMapper.INSTANCE.entityToDto(repository.findAll());
    }
    
     public List<BonificacaoDTO> consultarBonificacoesProfessor(Long idAluno) {
        return BonificacaoMapper.INSTANCE.entityToDto(repository.findAllByIdAluno(idAluno));
    }
    public List<BonificacaoDTO> consultarBonificacoesAluno(Long idProfessor) {
        return BonificacaoMapper.INSTANCE.entityToDto(repository.findAllByIdProfessor(idProfessor));
    }
}
