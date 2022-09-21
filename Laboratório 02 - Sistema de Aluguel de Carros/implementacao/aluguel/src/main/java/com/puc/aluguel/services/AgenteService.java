package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.AgenteMapper;
import com.puc.aluguel.model.dto.AgenteDTO;
import com.puc.aluguel.model.entity.Agente;
import com.puc.aluguel.model.enums.TipoUsuarioEnum;
import com.puc.aluguel.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {

    @Autowired
    AgenteRepository repository;

    public AgenteDTO criarAgente(AgenteDTO agenteDTO) {
        agenteDTO.setTipoUsuarioEnum(TipoUsuarioEnum.AGENTE);
        var patient = repository.save(AgenteMapper.INSTANCE.dtoToEntity(agenteDTO));
        return AgenteMapper.INSTANCE.entityToDto(patient);
    }

    public Agente buscarAgentePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinesException("Erro ao buscar agente"));
    }


}