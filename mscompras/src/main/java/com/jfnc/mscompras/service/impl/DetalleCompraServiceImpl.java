package com.jfnc.mscompras.service.impl;

import com.jfnc.mscompras.entity.DetalleCompra;
import com.jfnc.mscompras.repository.DetalleCompraRepository;
import com.jfnc.mscompras.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

    @Autowired
    DetalleCompraRepository detalleCompraRepository;

    @Autowired
    ApiProductoExtImpl apiProductoExt;

    @Override
    public DetalleCompra crearDetalleCompra(DetalleCompra detalleCompra) throws Exception {

        if(apiProductoExt.obtenerProducto(detalleCompra.getProducto()).getIdProducto()==null){
            throw new RuntimeException("El Producto no existe");
        }

        detalleCompra.setSubTotal(detalleCompra.getCantidad()* detalleCompra.getPrecioCompra());
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public List<DetalleCompra> listarDetalleCompra() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra detalleCompraPorId(Long id) {
        return detalleCompraRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleCompra modificarDetalleCompra(Long id, DetalleCompra detalleCompra) {
        if(detalleCompraRepository.existsById(id)){
            if(apiProductoExt.obtenerProducto(detalleCompra.getProducto()).getIdProducto()==null){
                throw new RuntimeException("El Producto no existe");
            }
            detalleCompra.setSubTotal(detalleCompra.getCantidad()* detalleCompra.getPrecioCompra());
            return detalleCompraRepository.save(detalleCompra);
        }
        return null;
    }

    @Override
    public void eliminarDetalleCompra(Long id) {

    }
}
