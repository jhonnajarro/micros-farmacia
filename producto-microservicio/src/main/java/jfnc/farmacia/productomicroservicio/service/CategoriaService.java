package jfnc.farmacia.productomicroservicio.service;

import jfnc.farmacia.productomicroservicio.entity.Categoria;
import jfnc.farmacia.productomicroservicio.entity.Producto;

import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    List<Categoria> listarCategorias();

    Categoria categoriaPorId(Long id);
    Categoria modificarCategoria(Long id, Categoria categoria);

    void eliminarCategoria(Long id);
}
