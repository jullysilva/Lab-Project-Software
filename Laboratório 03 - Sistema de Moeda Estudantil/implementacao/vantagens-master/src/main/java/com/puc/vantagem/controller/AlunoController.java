package com.puc.vantagem.controller;

import com.puc.vantagem.exceptions.BusinesException;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService service;


    @PostMapping(value = "/criar-aluno")
    public ResponseEntity<AlunoDTO> criarUsuario(@RequestBody AlunoDTO alunoDTO) {
        try {
            var response = service.criarAluno(alunoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/resgatar-vantagem/{idVantagem}/{idAluno}")
    public ResponseEntity<Void> resgatarVantagem(@PathVariable("idVantagem") Long idVantagem, @PathVariable("idAluno") Long idAluno) {
        try {
            service.resgatarVantagem(idVantagem, idAluno);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/login-aluno")
    public ResponseEntity<Boolean> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            var response = service.login(usuarioDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @GetMapping(value = "/consultar-extrato-aluno/{idAluno}")
    public ResponseEntity<Integer> consultarExtratoAluno(@PathVariable("idAluno") Long idAluno) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarExtrato(idAluno));
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }
}