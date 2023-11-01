package jfnc.farmacia.productomicroservicio.service;

import jfnc.farmacia.productomicroservicio.entity.Marca;

import java.util.List;

public interface MarcaService {
    Marca  crearMarca(Marca marca);
    List<Marca> listarMarcas();
    
    Marca marcaPorId(Long id);
    Marca modificarMarca(Long id, Marca marca);
    
    Marca eliminarMarca(Long id, Marca marca);

}
