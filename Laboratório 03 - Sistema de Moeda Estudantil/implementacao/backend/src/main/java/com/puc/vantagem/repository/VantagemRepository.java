package com.puc.vantagem.repository;

import com.puc.vantagem.model.entity.Aluno;
import com.puc.vantagem.model.entity.Vantagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VantagemRepository extends JpaRepository<Vantagem, Long> {

}