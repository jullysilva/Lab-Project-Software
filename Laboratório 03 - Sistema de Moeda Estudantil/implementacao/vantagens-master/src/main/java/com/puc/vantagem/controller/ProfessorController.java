package com.puc.vantagem.controller;

import com.puc.vantagem.exceptions.BusinesException;
import com.puc.vantagem.model.dto.BonificacaoDTO;
import com.puc.vantagem.model.dto.ProfessorDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.services.AlunoService;
import com.puc.vantagem.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService service;


    @PostMapping(value = "/criar-professor")
    public ResponseEntity<ProfessorDTO> criarUsuario(@RequestBody ProfessorDTO professorDTO) {
        try {
            var response = service.criarProfessor(professorDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @GetMapping(value = "/consultar-extrato-professor/{idProfessor}")
    public ResponseEntity<Integer> consultarExtrato(@PathVariable("idProfessor") Long idProfessor) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarExtrato(idProfessor));
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/login-professor")
    public ResponseEntity<Boolean> loginProfessor(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            var response = service.login(usuarioDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/enviar-bonificacao")
    public ResponseEntity<Void> enviarBonificacao(@RequestBody BonificacaoDTO bonificacaoDTO) {
        try {
            service.enviarBonificacao(bonificacaoDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }
}