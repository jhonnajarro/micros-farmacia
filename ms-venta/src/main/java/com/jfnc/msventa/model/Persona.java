package com.jfnc.msventa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class Persona {

    private Long idPersona;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;
    private String celular;
    private String sexo;
    private int estado;
    private Date fechaCrea;
    private Date fechaMod;
    private TipoPersona tipoPersona;


}

