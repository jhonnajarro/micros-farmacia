package jfnc.farmacia.productomicroservicio.service;

import jfnc.farmacia.productomicroservicio.entity.Almacen;

import java.util.List;

public interface AlmacenService {
    Almacen crearAlmacen(Almacen almacen);

    List<Almacen> listarAlmacen();

    Almacen almacenPorId(Long id);

    Almacen modificarAlmacen(Almacen almacen,Long id);

    void eliminarAlmacen(Long id);
}
