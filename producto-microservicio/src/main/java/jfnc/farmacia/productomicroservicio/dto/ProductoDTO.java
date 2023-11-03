package jfnc.farmacia.productomicroservicio.dto;

import jfnc.farmacia.productomicroservicio.entity.Categoria;
import jfnc.farmacia.productomicroservicio.entity.Inventario;
import jfnc.farmacia.productomicroservicio.entity.Marca;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class ProductoDTO {

    private Long idProducto;

    private String nombre;

    private String descripcion;

    private Date fechaCaducidad;
    private Double precio;
    private String codigo;
    private Marca marca;
    private Categoria categoria;
    private Inventario inventario;
}
