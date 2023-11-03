package com.jfnc.mscompras.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    private Date fechaCompra;
    private Double totalCompra;
    private int estado;
    private Date fechaMod;
    @ManyToOne
    @JoinColumn(name = "id_proveedor", foreignKey = @ForeignKey(name = "fk_compra_proveedor"),nullable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "compra",cascade = {CascadeType.ALL})
    private List<DetalleCompra> detalles;



}
