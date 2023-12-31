package com.jfnc.msventa.service.impl;

import com.jfnc.msventa.entity.DetalleVenta;
import com.jfnc.msventa.repository.DetalleVentaRepository;
import com.jfnc.msventa.service.DetalleVentaService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ApiProductoExtImpl apiProductoExt;
    @Override
    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) {
        Double precioProducto=apiProductoExt.obtenerProducto(detalleVenta.getIdProducto()).getPrecio();
        detalleVenta.setSubTotal(detalleVenta.getCantidad()* precioProducto);

        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public List<DetalleVenta> listarDetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta detalleVentaPorId(Long id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta modificarDetalleVenta(DetalleVenta detalleVenta, Long id) {
        if(detalleVentaRepository.existsById(id)){
            Double precioProducto=apiProductoExt.obtenerProducto(detalleVenta.getIdProducto()).getPrecio();
            detalleVenta.setSubTotal(detalleVenta.getCantidad()* precioProducto);
            return detalleVentaRepository.save(detalleVenta);
        }
        return null;
    }

    @Override
    public void eliminarDetalleVenta(Long id) {

    }
}
