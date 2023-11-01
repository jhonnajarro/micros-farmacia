package jfnc.farmacia.productomicroservicio.service.impl;

import jfnc.farmacia.productomicroservicio.entity.Categoria;
import jfnc.farmacia.productomicroservicio.repository.CategoriaRepository;
import jfnc.farmacia.productomicroservicio.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria categoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria modificarCategoria(Long id, Categoria categoria) {
        if(categoriaRepository.existsById(id)){
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }
    }
}
