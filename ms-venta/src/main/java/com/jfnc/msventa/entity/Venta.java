package com.jfnc.msventa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    @Column(name = "fecha_venta")
    private Date fechaVenta;

    private Long idCliente;
    private Long idUsuario;
    private Double totalVenta;

    @OneToMany(mappedBy = "venta" , cascade = {CascadeType.ALL})
    private List<DetalleVenta> listVentas;

    //PRECIO COMO SE PUEDE OBTENER DE CADA PRODUCTO
}
