package com.puc.aluguel.controller;


import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.model.dto.AutomovelDTO;
import com.puc.aluguel.services.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutomovelController {

    @Autowired
    private AutomovelService service;


    @GetMapping(value = "/buscar-todos-automoveis")
    public ResponseEntity<List<AutomovelDTO>> buscarTodosAutomoveis() {
        try {
            var response = service.buscarTodos();
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

    @PostMapping(value = "/salvar-automoveis")
    public ResponseEntity<List<AutomovelDTO>> salvarAutomoveis() {
        try {
            service.salvarListAutomoveis();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new BusinesException(e.getMessage());
        }
    }

}