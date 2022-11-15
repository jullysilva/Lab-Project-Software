package com.puc.vantagem.services;

import com.puc.vantagem.exceptions.BusinesException;
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

    @Autowired
    BonificacaoService bonificacaoService;

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
        var professor = repository.findById(usuarioDTO.getId())
                .orElseThrow(() -> new BusinesException("ID do professor nao encontrado"));

        return professor.getSenha().equals(usuarioDTO.getSenha())
                && professor.getEmail().equals(usuarioDTO.getEmail())
                && professor.getNome().equals(usuarioDTO.getNome());
    }

    public void retirarMoeda(Long idProfessor, Integer moeda) {
        var professor = repository.findById(idProfessor)
                .orElseThrow(() -> new BusinesException("Id do professor nao foi encontrado"));
        professor.setMoeda(professor.getMoeda() - moeda);
        repository.save(professor);
    }

    public void enviarBonificacao(BonificacaoDTO bonificacaoDTO) {
        var moedasProfessor = consultarExtrato(bonificacaoDTO.getIdProfessor());

        if (moedasProfessor < bonificacaoDTO.getCusto()) {
            throw new BusinesException("Professor não possui moedas suficientes");
        }

        alunoService.adicionarMoeda(bonificacaoDTO.getIdAluno(), bonificacaoDTO.getCusto());

        retirarMoeda(bonificacaoDTO.getIdProfessor(), bonificacaoDTO.getCusto());

        bonificacaoService.salvarBonificacao(bonificacaoDTO);
    }
}