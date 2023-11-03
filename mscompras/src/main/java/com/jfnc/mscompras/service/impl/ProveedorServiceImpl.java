package com.jfnc.mscompras.service.impl;

import com.jfnc.mscompras.entity.Proveedor;
import com.jfnc.mscompras.repository.ProveedorRepository;
import com.jfnc.mscompras.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        proveedor.setEstado(1);
        proveedor.setFechaCrea(new Date());
        return proveedorRepository.save(proveedor);
    }

    @Override
    public List<Proveedor> listarProveedor() {
        List<Proveedor> proveedores = proveedorRepository.findAllByEstado(1);
        return proveedores;
    }

    @Override
    public Proveedor proveedorPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor modificarProveedor(Long id, Proveedor proveedor) {
            if(proveedorRepository.existsById(id)){
                proveedor.setFechaMod(new Date());
                return proveedorRepository.save(proveedor);
            }

        return null;
    }

    @Override
    public Proveedor eliminarProveedor(Long id) {
        if(proveedorRepository.existsById(id)){
           Proveedor proveedor= proveedorRepository.findById(id).orElse(null);
           proveedor.setEstado(0);
           proveedor.setFechaMod(new Date());
           return proveedorRepository.save(proveedor);
        }
        return null;
    }
}
