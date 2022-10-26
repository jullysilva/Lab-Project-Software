package com.puc.vantagem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;

}
