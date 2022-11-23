package com.puc.vantagem.controller;

import com.puc.vantagem.exceptions.BusinesException;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.BonificacaoDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.services.AlunoService;
import com.puc.vantagem.services.BonificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BonificacaoController {

    @Autowired
    private BonificacaoService service;

    @GetMapping(value = "/consultar-bonificacoes")
    public ResponseEntity<List<BonificacaoDTO>> consultarExtratoAluno() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarBonificacoes());
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }
    @GetMapping(value = "/consultar-bonificacoes/{idProfssor}")
    public ResponseEntity<List<BonificacaoDTO>> buscarExtratoPorProfessor(@PathVariable("idProfssor") Long idProfssor) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarBonificacoesProfessor(idProfssor));
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @GetMapping(value = "/consultar-bonificacoes/{idAluno}")
    public ResponseEntity<List<BonificacaoDTO>> buscarExtratoPorAluno(@PathVariable("idAluno") Long idAluno) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarBonificacoesAluno(idAluno));
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }
}
