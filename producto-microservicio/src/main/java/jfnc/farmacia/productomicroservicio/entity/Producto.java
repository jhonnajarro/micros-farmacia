package jfnc.farmacia.productomicroservicio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    @Column(name = "nombre", nullable = false,length = 45)
    private String nombre;
    @Column(name = "descripcion", nullable = false,length = 200)
    private String descripcion;
    @Column(name = "fecha_crea")
    private Date fechaCrea;
    @Column(name = "fecha_mod")
    private Date fechaMod;

    @Column(name = "fecha_caducidad")
    private Date fechaCaducidad;
    private Double precio;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private Integer proveedor;

}
