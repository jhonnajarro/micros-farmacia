package com.jfnc.msventa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class Almacen {
    private Long idAlmacen;
    private String nombreAlmacen;
}
