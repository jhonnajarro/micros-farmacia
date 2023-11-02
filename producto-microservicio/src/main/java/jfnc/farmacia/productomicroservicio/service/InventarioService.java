package jfnc.farmacia.productomicroservicio.service;

import jfnc.farmacia.productomicroservicio.entity.Categoria;
import jfnc.farmacia.productomicroservicio.entity.Inventario;

import java.util.List;

public interface InventarioService {

    Inventario crearInventario(Inventario inventario);
    List<Inventario> listarInventario();

    Inventario inventarioPorId(Long id);
    Inventario modificarInventario(Long id, Inventario inventario);

    void eliminarInventario(Long id);
}
