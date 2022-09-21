package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.PedidoMapper;
import com.puc.aluguel.model.dto.AgentePedidoDTO;
import com.puc.aluguel.model.dto.ContratoDTO;
import com.puc.aluguel.model.dto.PedidoDTO;
import com.puc.aluguel.model.dto.UsuarioDTO;
import com.puc.aluguel.model.entity.Contrato;
import com.puc.aluguel.model.entity.Pedido;
import com.puc.aluguel.model.enums.TipoRegistroEnum;
import com.puc.aluguel.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    @Autowired
    AutomovelService automovelService;

    @Autowired
    AgenteService agenteService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ContratoService contratoService;

    public PedidoDTO criarPedido(Long idAutomovel, Long idCliente, TipoRegistroEnum tipoRegistroEnum, String usuario, String senha) {

        var cliente = clienteService.buscarEntityClienteDTOPorId(idCliente);

        usuarioService.validaUsuarioCliente(usuario, senha);

        var pedido = repository.save(PedidoMapper.INSTANCE.dtoToEntity(PedidoDTO.builder().build()));
        var contrato = gerarContratoDTO(tipoRegistroEnum);
        var automovel = automovelService.buscarEntityAutomovelPorId(idAutomovel);

        pedido.setContrato(contrato);
        pedido.setAutomovel(automovel);
        pedido.setCliente(cliente);

        return PedidoMapper.INSTANCE.entityToDto(repository.save(pedido));
    }

    public Contrato gerarContratoDTO(TipoRegistroEnum tipoRegistroEnum) {
        return contratoService.gerarContrato(ContratoDTO.builder().dataInicioContrato(LocalDate.now()).dataFimContrato(LocalDate.now().plusDays(4)).tipoRegistroEnum(tipoRegistroEnum).build());
    }

    public PedidoDTO avaliarPedido(AgentePedidoDTO agentePedidoDTO) {

        usuarioService.validaUsuarioAgente(agentePedidoDTO.getEmail(), agentePedidoDTO.getSenha());

        var pedido = buscarPedidoPorId(agentePedidoDTO.getId());

        var agente = agenteService.buscarAgentePorId(agentePedidoDTO.getIdAgente());

        pedido.setAgente(agente);
        pedido.setConcideracaoAgente(agentePedidoDTO.getConcideracao());
        pedido.setParecer(agentePedidoDTO.getParecer());

        return PedidoMapper.INSTANCE.entityToDto(pedido);
    }

    public Pedido buscarPedidoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinesException("Erro ao buscar pedido"));
    }

    public PedidoDTO consultarPedidoPorCliente(String email) {
        return PedidoMapper.INSTANCE.entityToDto(repository.buscarPedidoPorEmailCliente(email).orElseThrow(() -> new BusinesException("Erro ao buscar pedido")));
    }

    public PedidoDTO consultarPedidoPorAgente(String email) {
        return PedidoMapper.INSTANCE.entityToDto(repository.buscarPedidoPorEmailAgente(email).orElseThrow(() -> new BusinesException("Erro ao buscar pedido")));
    }

    public List<PedidoDTO> consultarTodosPedidos() {
        return PedidoMapper.INSTANCE.entityToDto(repository.findAll());
    }
}