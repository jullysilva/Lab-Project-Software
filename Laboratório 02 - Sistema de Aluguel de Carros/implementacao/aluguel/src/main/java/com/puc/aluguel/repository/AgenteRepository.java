package com.puc.aluguel.repository;

import com.puc.aluguel.model.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {
    Agente findByEmail(String email);
}