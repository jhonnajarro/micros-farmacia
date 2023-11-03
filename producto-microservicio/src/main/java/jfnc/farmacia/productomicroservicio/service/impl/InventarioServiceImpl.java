package jfnc.farmacia.productomicroservicio.service.impl;

import jfnc.farmacia.productomicroservicio.entity.Inventario;
import jfnc.farmacia.productomicroservicio.repository.InventarioRepository;
import jfnc.farmacia.productomicroservicio.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public Inventario crearInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public List<Inventario> listarInventario() {
        return null;
    }

    @Override
    public Inventario inventarioPorId(Long id) {
        return null;
    }

    @Override
    public Inventario modificarInventario(Long id, Inventario inventario) {
        if (inventarioRepository.existsById(id)){

            return inventarioRepository.save(inventario);
        }
        return null;
    }

    @Override
    public void eliminarInventario(Long id) {

    }
}
