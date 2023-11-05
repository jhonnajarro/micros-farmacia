package com.jfnc.msventa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class TipoPersona {

    private Long idTipoPersona;
    private String denominacion;
    private String descripcion;
}
