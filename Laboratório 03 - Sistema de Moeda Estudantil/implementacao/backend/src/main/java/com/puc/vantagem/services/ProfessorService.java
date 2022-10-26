package com.puc.vantagem.services;

import com.puc.vantagem.mapper.ProfessorMapper;
import com.puc.vantagem.model.dto.BonificacaoDTO;
import com.puc.vantagem.model.dto.ProfessorDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    @Autowired
    AlunoService alunoService;

    public ProfessorDTO criarProfessor(ProfessorDTO professorDTO) {
        professorDTO.setMoeda(1000);
        var professor = repository.save(ProfessorMapper.INSTANCE.dtoToEntity(professorDTO));
        return ProfessorMapper.INSTANCE.entityToDto(professor);
    }

    public Integer consultarExtrato(Long idProfessor) {
        var professor = repository.findById(idProfessor);
        return professor.get().getMoeda();
    }

    public boolean login(UsuarioDTO usuarioDTO) {
        var aluno = repository.findById(usuarioDTO.getId());

        if (aluno.get().getSenha().equals(usuarioDTO.getSenha())) {
            return true;
        }
        return false;
    }

    public void retirarMoeda(Long idProfessor, Integer moeda) {
        var professor = repository.findById(idProfessor);
        professor.get().setMoeda(professor.get().getMoeda() - moeda);
        repository.save(professor.get());
    }

    public void enviarBonificacao(BonificacaoDTO bonificacaoDTO) {
        alunoService.adicionarMoeda(bonificacaoDTO.getIdAluno(), bonificacaoDTO.getCusto());
        retirarMoeda(bonificacaoDTO.getIdProfessor(), bonificacaoDTO.getCusto());
    }
}