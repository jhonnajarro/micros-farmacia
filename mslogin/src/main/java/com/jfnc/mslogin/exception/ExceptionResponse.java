package com.jfnc.mslogin.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class ExceptionResponse {
    private LocalDateTime fecha;
    private String mensaje;
    private String detalle;

    public ExceptionResponse(){

    }

    public ExceptionResponse(LocalDateTime fecha, String mensaje, String detalle) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }
}
