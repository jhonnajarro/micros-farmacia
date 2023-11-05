package com.jfnc.mscompras.service.impl;

import com.jfnc.mscompras.entity.Compra;
import com.jfnc.mscompras.repository.CompraRepository;
import com.jfnc.mscompras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    CompraRepository compraRepository;
    @Override
    public Compra crearCompra(Compra compra) {
        compra.getDetalles().forEach(det -> det.setCompra(compra));
        compra.setEstado(1);
        compra.setFechaCompra(new Date());
        compra.setTotalCompra(compra.getDetalles().stream().mapToDouble(dc-> dc.getSubTotal()).sum());

        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> listarCompra() {
    List<Compra> compras=compraRepository.findAllByEstado(1);
        return compras;
    }

    @Override
    public Compra compraPorId(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public Compra modificarCompra(Long id, Compra compra) {
        if(compraRepository.existsById(id)){
            compra.setFechaMod(new Date());
            compra.setTotalCompra(compra.getDetalles().stream().mapToDouble(dc-> dc.getSubTotal()).sum());
            return compraRepository.save(compra);
        }
        return null;
    }

    @Override
    public void eliminarCompra(Long id) {
        if(compraRepository.existsById(id)){
            Compra compra = compraRepository.findById(id).orElse(null);

            compraRepository.save(compra);
        }
    }
}
