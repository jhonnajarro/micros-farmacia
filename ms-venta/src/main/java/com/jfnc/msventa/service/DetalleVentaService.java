package com.jfnc.msventa.service;

import com.jfnc.msventa.entity.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {

    DetalleVenta crearDetalleVenta (DetalleVenta detalleVenta);

    List<DetalleVenta> listarDetalleVenta();

    DetalleVenta detalleVentaPorId(Long id);

    DetalleVenta modificarDetalleVenta(DetalleVenta detalleVenta,Long id);

    void eliminarDetalleVenta(Long id);
}
