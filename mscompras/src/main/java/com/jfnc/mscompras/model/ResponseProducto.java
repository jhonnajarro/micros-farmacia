package com.jfnc.mscompras.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResponseProducto {
    private Long idProducto;

    private String nombre;

    private String descripcion;

    private Date fechaCrea;

    private Date fechaMod;

    private int estado;

    private Date fechaCaducidad;
    private Double precio;
    private String codigo;

    private Marca marca;

    private Categoria categoria;

    private Inventario inventario;
}
