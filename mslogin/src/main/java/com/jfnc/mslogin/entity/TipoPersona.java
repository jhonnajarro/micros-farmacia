package com.jfnc.mslogin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tipo_persona")
public class TipoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPersona;

    private String denominacion;
    private String descripcion;
}
