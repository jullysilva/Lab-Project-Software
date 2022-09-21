package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.ClienteMapper;
import com.puc.aluguel.model.dto.ClienteDTO;
import com.puc.aluguel.model.entity.Cliente;
import com.puc.aluguel.model.enums.TipoUsuarioEnum;
import com.puc.aluguel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        clienteDTO.setTipoUsuarioEnum(TipoUsuarioEnum.CLIENTE);
        var cliente = repository.save(ClienteMapper.INSTANCE.dtoToEntity(clienteDTO));
        return ClienteMapper.INSTANCE.entityToDto(cliente);
    }

    public Cliente buscarEntityClienteDTOPorId(Long idCliente) {
        return repository.findById(idCliente).orElseThrow(() -> new BusinesException("Erro ao buscar pedido"));
    }
}