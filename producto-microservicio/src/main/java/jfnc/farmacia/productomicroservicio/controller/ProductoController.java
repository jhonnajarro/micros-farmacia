package jfnc.farmacia.productomicroservicio.controller;

import jfnc.farmacia.productomicroservicio.dto.ProductoDTO;
import jfnc.farmacia.productomicroservicio.entity.Inventario;
import jfnc.farmacia.productomicroservicio.entity.Producto;
import jfnc.farmacia.productomicroservicio.service.InventarioService;
import jfnc.farmacia.productomicroservicio.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private  ProductoService productoService;

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listarProductos")
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos =productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Producto> listarPorId(@PathVariable Long id){
        Producto producto=productoService.productoPorId(id);
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Producto> guardar(@RequestBody ProductoDTO productoDTO){
        Producto productoIN= modelMapper.map(productoDTO,Producto.class);
        Inventario inventarioIn=productoIN.getInventario();
        Inventario inventarioBD=inventarioService.crearInventario(inventarioIn);
        productoIN.setInventario(inventarioBD);
        Producto productoBD=productoService.crearProducto(productoIN);

        return new ResponseEntity<>(productoBD, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Producto> modificar(@PathVariable Long id,@RequestBody Producto producto){

        Inventario inventarioIN=producto.getInventario();
        Inventario inventarioBD=inventarioService.modificarInventario(inventarioIN.getIdInventario(),inventarioIN);
        producto.setInventario(inventarioBD);
        Producto productoBD=productoService.modificarProducto(id,producto);
        return new ResponseEntity<>(productoBD,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id){
        Producto productoEliminado=productoService.eliminarProducto(id);
        return new ResponseEntity<>(productoEliminado,HttpStatus.OK);
    }
}
