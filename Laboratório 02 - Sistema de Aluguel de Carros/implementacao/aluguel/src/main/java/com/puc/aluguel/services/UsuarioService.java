package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.repository.AgenteRepository;
import com.puc.aluguel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    AgenteRepository agenteRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void validaUsuarioAgente(String email, String senha) {
        var agente = agenteRepository.findByEmail(email);
        if (!senha.equals(agente.getSenha())) throw new BusinesException("Usuario ou senha incorretos");
    }

    public void validaUsuarioCliente(String email, String senha) {
        var cliente = clienteRepository.findByEmail(email);
        if (!senha.equals(cliente.getSenha())) throw new BusinesException("Usuario ou senha incorretos");
    }

}