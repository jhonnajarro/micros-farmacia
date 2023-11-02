package jfnc.farmacia.productomicroservicio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "almacen")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlmacen;

    @Column(name = "nombre_almacen",length = 100)
    private String nombreAlmacen;
}
