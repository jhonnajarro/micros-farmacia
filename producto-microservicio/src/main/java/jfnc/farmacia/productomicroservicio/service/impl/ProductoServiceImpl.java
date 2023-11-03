package jfnc.farmacia.productomicroservicio.service.impl;

import jfnc.farmacia.productomicroservicio.entity.Producto;
import jfnc.farmacia.productomicroservicio.repository.ProductoRepository;
import jfnc.farmacia.productomicroservicio.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    //@Transactional
    @Override
    public Producto crearProducto(Producto producto) {
        //producto.getInventario().setProducto(producto);
        producto.setEstado(1);
        producto.setFechaCrea(new Date());
        return productoRepository.save(producto) ;
    }

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos= productoRepository.findAllByEstado(1);
        return productos;
    }

    @Override
    public Producto productoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto modificarProducto(Long id, Producto producto) {
        if(productoRepository.existsById(id)){
            producto.setFechaMod(new Date());
          return  productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public Producto eliminarProducto(Long id) {
        if(productoRepository.existsById(id)){
            Producto producto= productoRepository.findById(id).orElse(null);
            producto.setEstado(0);
            producto.setFechaMod(new Date());
            return productoRepository.save(producto);
        }
        return null;
    }
}
