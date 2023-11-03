package com.jfnc.mscompras.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    private String razonSocial;
    private Date fechaCrea;
    private Date fechaMod;
    @Column(name = "celular", length = 9)
    private String celular;
    private String direccion;
    private String correo;
    private int estado;
    @Column(name = "ruc", length = 11)
    private String ruc;
}
