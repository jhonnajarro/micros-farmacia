package com.jfnc.mscompras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jfnc.mscompras.model.ResponseProducto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "detalle_compra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCompra;
    private Double precioCompra;
    private Double subTotal;
    private Double cantidad;
    private Long producto;
    @ManyToOne
    @JoinColumn(name = "id_compra", foreignKey = @ForeignKey(name = "fk_detallecompra_compra"),nullable = true)
    @JsonIgnore
    private Compra compra;

}
