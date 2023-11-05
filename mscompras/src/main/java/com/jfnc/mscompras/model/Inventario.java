package com.jfnc.mscompras.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventario {
    private Long idInventario;
    private double stock;
    private double stockMinimo;
    private Almacen almacen;
}
