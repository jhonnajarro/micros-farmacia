package jfnc.farmacia.productomicroservicio.service;

import jfnc.farmacia.productomicroservicio.entity.Producto;

import java.util.List;

public interface ProductoService {
    Producto  crearProducto(Producto producto);
    List<Producto> listarProductos();

    Producto productoPorId(Long id);
    Producto modificarProducto(Long id, Producto producto);

    Producto eliminarProducto(Long id);

}
