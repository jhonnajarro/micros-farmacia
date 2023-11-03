package com.jfnc.mscompras.service;

import com.jfnc.mscompras.entity.Compra;

import java.util.List;

public interface CompraService {

    Compra crearCompra(Compra compra);

    List<Compra> listarCompra();

    Compra compraPorId(Long id);

    Compra modificarCompra(Long id, Compra compra);

    void eliminarCompra(Long id);

}
