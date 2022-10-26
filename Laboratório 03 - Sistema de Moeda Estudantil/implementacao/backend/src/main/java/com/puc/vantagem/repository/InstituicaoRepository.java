package com.puc.vantagem.repository;

import com.puc.vantagem.model.entity.Aluno;
import com.puc.vantagem.model.entity.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

}