package com.jfnc.msventa.service.impl;

import com.jfnc.msventa.entity.Venta;
import com.jfnc.msventa.repository.VentaRepository;
import com.jfnc.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaRepository ventaRepository;

    @Override
    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> listarVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta ventaPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta modificarVenta(Venta venta, Long id) {
        if(ventaRepository.existsById(id)){
            return ventaRepository.save(venta);
        }
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {
        if(ventaRepository.existsById(id)){
            ventaRepository.deleteById(id);
        }
    }
}
