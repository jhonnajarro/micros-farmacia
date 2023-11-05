package com.jfnc.msventa.service;

import com.jfnc.msventa.entity.Venta;

import java.util.List;

public interface VentaService {

    Venta crearVenta(Venta venta) throws Exception;

    List<Venta> listarVenta();

    Venta ventaPorId(Long id);

    Venta modificarVenta(Venta venta, Long id);

    void eliminarVenta(Long id);
}
