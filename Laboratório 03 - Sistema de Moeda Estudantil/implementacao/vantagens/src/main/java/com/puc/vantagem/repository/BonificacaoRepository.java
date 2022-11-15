package com.puc.vantagem.repository;

import com.puc.vantagem.model.entity.Bonificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonificacaoRepository extends JpaRepository<Bonificacao, Long> {

    List<Bonificacao> findAllByIdAluno(Long idAluno);

    List<Bonificacao> findAllByIdProfessor(Long idProfessor);
}