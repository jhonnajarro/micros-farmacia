package com.jfnc.msventa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class ResponseUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String usuario;
    private String password;
    private int estado;
    private String rol;
    private Date fechaCrea;
    private Date fechaMod;
    private  Persona persona;
}
