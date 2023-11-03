package jfnc.farmacia.productomicroservicio.service.impl;

import jfnc.farmacia.productomicroservicio.entity.Almacen;
import jfnc.farmacia.productomicroservicio.repository.AlmacenReporitory;
import jfnc.farmacia.productomicroservicio.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    AlmacenReporitory almacenReporitory;

    @Override
    public Almacen crearAlmacen(Almacen almacen) {
        return null;
    }

    @Override
    public List<Almacen> listarAlmacen() {
        return null;
    }

    @Override
    public Almacen almacenPorId(Long id) {
        return null;
    }

    @Override
    public Almacen modificarAlmacen(Almacen almacen, Long id) {
        return null;
    }

    @Override
    public void eliminarAlmacen(Long id) {

    }
}
