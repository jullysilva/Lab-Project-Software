package com.puc.aluguel.services;

import com.puc.aluguel.mapper.ContratoMapper;
import com.puc.aluguel.model.dto.ContratoDTO;
import com.puc.aluguel.model.entity.Contrato;
import com.puc.aluguel.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {

    @Autowired
    ContratoRepository repository;

    public Contrato gerarContrato(ContratoDTO contratoDTO) {
        return repository.save(ContratoMapper.INSTANCE.dtoToEntity(contratoDTO));
    }
}