package com.puc.vantagem.controller;

import com.puc.vantagem.exceptions.BusinesException;
import com.puc.vantagem.model.dto.VantagemDTO;
import com.puc.vantagem.services.VantagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VantagemController {

    @Autowired
    private VantagemService service;


    @GetMapping(value = "/buscar-todas-vantagens")
    public ResponseEntity<List<VantagemDTO>> buscarVantagem() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.consultarVantagens());
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/cadastrar-vantagens")
    public ResponseEntity<VantagemDTO> cadastrarVantagem(@RequestBody VantagemDTO vantagemDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.criarVantagem(vantagemDTO));
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

//    @GetMapping(value = "/consultar-minhas-vantagens/{idAluno}")
//    public ResponseEntity<VantagemDTO> consultarExtratoAluno(@PathVariable("idAluno") Long idAluno) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(service.consultarMinhasVantagens(idAluno));
//        } catch (Exception e) {
//            throw new BusinesException(e.getMessage());
//        }
//    }
}