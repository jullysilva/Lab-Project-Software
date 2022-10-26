package com.puc.vantagem.services;

import com.puc.vantagem.mapper.AlunoMapper;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.model.entity.Vantagem;
import com.puc.vantagem.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    @Autowired
    VantagemService vantagemService;

    public AlunoDTO criarAluno(AlunoDTO alunoDTO) {
        alunoDTO.setMoeda(0);
        var aluno = repository.save(AlunoMapper.INSTANCE.dtoToEntity(alunoDTO));
        return AlunoMapper.INSTANCE.entityToDto(aluno);
    }

    public Integer consultarExtrato(Long idAluno) {
        var aluno = repository.findById(idAluno);
        return aluno.get().getMoeda();
    }

    public void adicionarMoeda(Long idAluno, Integer moeda) {
        var aluno = repository.findById(idAluno);
        aluno.get().setMoeda(aluno.get().getMoeda() + moeda);
        repository.save(aluno.get());
    }

    public boolean login(UsuarioDTO usuarioDTO) {
        var aluno = repository.findById(usuarioDTO.getId());

        if (aluno.get().getSenha().equals(usuarioDTO.getSenha())) {
            return true;
        }
        return false;
    }

    public void resgatarVantagem(Long idVantagem, Long idAluno) {
        var vantagem = vantagemService.buscarVantagemPorId(idVantagem);
        var aluno = repository.findById(idAluno).get();

        aluno.setMoeda(aluno.getMoeda() - vantagem.getCusto());
        aluno.getVantagens().add(vantagem);

        repository.save(aluno);
    }
}