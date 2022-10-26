package com.puc.vantagem.controller;

import com.puc.vantagem.exceptions.BusinesException;
import com.puc.vantagem.model.dto.AlunoDTO;
import com.puc.vantagem.model.dto.InstituicaoDTO;
import com.puc.vantagem.model.dto.UsuarioDTO;
import com.puc.vantagem.services.AlunoService;
import com.puc.vantagem.services.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InstituicaoController {

    @Autowired
    private InstituicaoService service;


    @PostMapping(value = "/criar-instituicao")
    public ResponseEntity<InstituicaoDTO> criarInstituicao(@RequestBody InstituicaoDTO instituicaoDTO) {
        try {
            var response = service.criarInstituicao(instituicaoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

}