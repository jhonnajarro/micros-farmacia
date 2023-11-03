package jfnc.farmacia.productomicroservicio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private double stock;
    private double stockMinimo;

    @ManyToOne
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @OneToOne(mappedBy = "inventario")
    @JsonIgnore
    private Producto producto;
}
