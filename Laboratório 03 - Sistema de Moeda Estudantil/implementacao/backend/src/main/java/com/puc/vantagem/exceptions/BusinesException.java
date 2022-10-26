package com.puc.vantagem.exceptions;

import org.springframework.http.HttpStatus;


public class BusinesException extends RuntimeException {
    private final HttpStatus status;

    public BusinesException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.status = status;
    }

    public BusinesException(String mensagem) {
        super(mensagem);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
