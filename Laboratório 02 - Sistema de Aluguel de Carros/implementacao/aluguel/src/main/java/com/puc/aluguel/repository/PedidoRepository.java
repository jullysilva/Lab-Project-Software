package com.puc.aluguel.repository;

import com.puc.aluguel.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.agente.email = :email")
    Optional<Pedido> buscarPedidoPorEmailAgente(@Param("email") String email);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.email = :email")
    Optional<Pedido> buscarPedidoPorEmailCliente(@Param("email") String email);
}