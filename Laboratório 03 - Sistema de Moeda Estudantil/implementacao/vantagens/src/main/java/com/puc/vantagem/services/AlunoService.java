package com.puc.vantagem.services;

import com.puc.vantagem.exceptions.BusinesException;
import com.puc.vantagem.mapper.AlunoMapper;
import com.puc.vantagem.mapper.VantagemMapper;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.model.entity.Vantagem;
import com.puc.vantagem.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        var aluno = repository.findById(idAluno)
                .orElseThrow(() -> new BusinesException("ID do aluno nao encontrado"));

        aluno.setMoeda(aluno.getMoeda() + moeda);

        repository.save(aluno);
    }

    public boolean login(UsuarioDTO usuarioDTO) {
        var aluno = repository.findById(usuarioDTO.getId())
                .orElseThrow(() -> new BusinesException("ID do aluno nao encontrado"));

        return aluno.getSenha().equals(usuarioDTO.getSenha())
                && aluno.getEmail().equals(usuarioDTO.getEmail())
                && aluno.getNome().equals(usuarioDTO.getNome());
    }

    public void resgatarVantagem(Long idVantagem, Long idAluno) {

        var moedasAluno = consultarExtrato(idAluno);

        var vantagem = vantagemService.buscarVantagemPorId(idVantagem);

        var aluno = repository.findById(idAluno)
                .orElseThrow(() -> new BusinesException("Id do aluno nao encontrado"));

        if (moedasAluno < vantagem.getCusto()) {
            throw new BusinesException("Aluno não possui moedas suficientes");
        }

        aluno.setMoeda(aluno.getMoeda() - vantagem.getCusto());
        aluno.getVantagens().add(vantagem);

        repository.save(aluno);
    }

    public AlunoDTO buscarAlunoPorId(Long idAluno) {
        return AlunoMapper.INSTANCE.entityToDto(repository.findById(idAluno)
                .orElseThrow(() -> new BusinesException("Id do aluno nao encontrado")));
    }

    public List<VantagemDTO> consultarVatagensAluno(Long idAluno) {
        var aluno = buscarAlunoPorId(idAluno);
        return VantagemMapper.INSTANCE.entityListToDtoList(aluno.getVantagens());
    }
}