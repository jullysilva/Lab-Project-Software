package com.puc.vantagem.services;

import com.puc.vantagem.mapper.AlunoMapper;
import com.puc.vantagem.mapper.VantagemMapper;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.model.entity.Vantagem;
import com.puc.vantagem.repository.AlunoRepository;
import com.puc.vantagem.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VantagemService {

    @Autowired
    VantagemRepository repository;

    public VantagemDTO criarVantagem(VantagemDTO vantagemDTO) {
        return VantagemMapper.INSTANCE.entityToDto(repository.save(VantagemMapper.INSTANCE.dtoToEntity(vantagemDTO)));
    }

    public List<VantagemDTO> consultarVantagens() {
        var vantagemList = repository.findAll();
        return VantagemMapper.INSTANCE.entityListToDtoList(vantagemList);
    }

    public Vantagem buscarVantagemPorId(Long idVantagem) {
        var vantagem = repository.findById(idVantagem);
        return vantagem.get();
    }

//    public List<VantagemDTO> consultarMinhasVantagens(Long idAluno) {
//
//    }
}