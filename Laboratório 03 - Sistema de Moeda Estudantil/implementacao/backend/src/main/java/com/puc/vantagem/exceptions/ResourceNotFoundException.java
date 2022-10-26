package com.puc.vantagem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static String GENERIC_ERRO_MSG = "Nenhum registro encontrado";

    public ResourceNotFoundException(String ex) {
        super(ex);
    }

    public ResourceNotFoundException() {
        super(GENERIC_ERRO_MSG);
    }

}
