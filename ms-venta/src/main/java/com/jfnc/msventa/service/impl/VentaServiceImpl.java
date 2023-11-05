package com.jfnc.msventa.service.impl;

import com.jfnc.msventa.entity.Venta;
import com.jfnc.msventa.repository.VentaRepository;
import com.jfnc.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    ApiUsuarioExtImpl apiUsuarioExt;

    @Override
    public Venta crearVenta(Venta venta)throws Exception {
        Long idUsuario=apiUsuarioExt.obtenerUsuario(venta.getIdUsuario()).getIdUsuario();
        if(idUsuario==null){
            throw new RuntimeException("Usuario no existe" +idUsuario);
        }
        venta.getListVentas().forEach(det-> det.setVenta(venta));
        venta.setFechaVenta(new Date());
        venta.setTotalVenta(venta.getListVentas().stream().mapToDouble(dv->dv.getSubTotal()).sum());
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
