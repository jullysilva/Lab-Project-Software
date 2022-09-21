package com.puc.aluguel.controller;


import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.model.dto.ClienteDTO;
import com.puc.aluguel.model.dto.PedidoDTO;
import com.puc.aluguel.model.dto.UsuarioDTO;
import com.puc.aluguel.model.enums.TipoRegistroEnum;
import com.puc.aluguel.services.ClienteService;
import com.puc.aluguel.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/criar-cliente")
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            var response = service.criarCliente(clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/introduzir-pedido/{idAutomovel}/{tipoRegistro}/{idCliente}")
    public ResponseEntity<PedidoDTO> introduzirPedido(@PathVariable("idAutomovel") Long idAutomovel, @PathVariable("tipoRegistro") TipoRegistroEnum tipoRegistroEnum, @PathVariable("idCliente") Long idCliente, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            var response = pedidoService.criarPedido(idAutomovel, idCliente, tipoRegistroEnum, usuarioDTO.getEmail(), usuarioDTO.getSenha());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @GetMapping(value = "/consultar-pedido-por-agente/{email}")
    public ResponseEntity<PedidoDTO> consultarPedido(@PathVariable("email") String email) {
        try {
            var response = pedidoService.consultarPedidoPorAgente(email);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @GetMapping(value = "/consultar-pedido-por-cliente/{email}")
    public ResponseEntity<PedidoDTO> consultarPedidoPorCliente(@PathVariable("email") String email) {
        try {
            var response = pedidoService.consultarPedidoPorCliente(email);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @GetMapping(value = "/consultar-todos-pedidos")
    public ResponseEntity<List<PedidoDTO>> consultarTodosPedido() {
        try {
            var response = pedidoService.consultarTodosPedidos();
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

}