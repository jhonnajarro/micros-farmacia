package com.jfnc.mscompras.service;

import com.jfnc.mscompras.entity.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {

    DetalleCompra crearDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    List<DetalleCompra> listarDetalleCompra();

    DetalleCompra detalleCompraPorId(Long id);

    DetalleCompra modificarDetalleCompra(Long id, DetalleCompra detalleCompra);

    void eliminarDetalleCompra(Long id);
}
