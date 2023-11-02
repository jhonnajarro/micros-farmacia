package jfnc.farmacia.productomicroservicio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    @Column(name = "stock")
    private double stock;
    private double stockMinimo;

    @ManyToOne
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
