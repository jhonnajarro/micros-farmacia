package com.jfnc.msventa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Inventario {

    private Long idInventario;
    private double stock;
    private double stockMinimo;
    private Almacen almacen;


}
