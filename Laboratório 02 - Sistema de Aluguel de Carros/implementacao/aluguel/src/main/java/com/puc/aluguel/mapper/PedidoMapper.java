package com.puc.aluguel.mapper;

import com.puc.aluguel.model.dto.PedidoDTO;
import com.puc.aluguel.model.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
    PedidoDTO entityToDto(Pedido entity);

    Pedido dtoToEntity(PedidoDTO dto);

    List<PedidoDTO> entityToDto(List<Pedido> entity);


    List<Pedido> dtoToEntity(List<PedidoDTO> dto);
}
