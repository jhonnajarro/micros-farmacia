package com.jfnc.mscompras.controller;

import com.jfnc.mscompras.dto.CompraDTO;
import com.jfnc.mscompras.entity.Compra;
import com.jfnc.mscompras.entity.DetalleCompra;
import com.jfnc.mscompras.model.ResponseProducto;
import com.jfnc.mscompras.repository.CompraRepository;
import com.jfnc.mscompras.service.CompraService;
import com.jfnc.mscompras.service.DetalleCompraService;
import com.jfnc.mscompras.service.impl.ApiProductoExtImpl;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    CompraService compraService;

    @Autowired
    DetalleCompraService detalleCompraService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ApiProductoExtImpl apiProductoExt;

    @GetMapping("/obtenerProductoOfCompras")
    public ResponseProducto obtenerProducto(@RequestParam(required = true) Long id) {
        return apiProductoExt.obtenerProducto(id);
    }

    @GetMapping("/listarCompras")
    public ResponseEntity<List<Compra>> listar() {
        List<Compra> compras = compraService.listarCompra();
        return new ResponseEntity<>(compras, HttpStatus.OK);
    }


    @PostMapping("/registrarCompra")
    public ResponseEntity<Compra> guardar(@RequestBody CompraDTO compraDTO) throws Exception {
        Compra compraIN = modelMapper.map(compraDTO, Compra.class);
        List<DetalleCompra> detalles = compraDTO.getDetalles();

        List<DetalleCompra> detallesBD = detalles.stream().map(detalleCompra -> {
            try {
                return detalleCompraService.crearDetalleCompra(detalleCompra);
            } catch (Exception e) {
                throw new RuntimeException("El producto no existe " + detalleCompra.getProducto());
            }
        }).collect(Collectors.toList());
        compraIN.setDetalles(detallesBD);
        Compra compraBD = compraService.crearCompra(compraIN);

        return new ResponseEntity<>(compraBD, HttpStatus.CREATED);
    }

    @PutMapping("/modificarCompra/{id}")
    public ResponseEntity<Compra> modificar(@PathVariable Long id, @RequestBody CompraDTO compraDTO) {
        Compra compraIN = modelMapper.map(compraDTO, Compra.class);
        List<DetalleCompra> detalles = compraIN.getDetalles();

        List<DetalleCompra> detallesBD = detalles.stream().map(detalleCompra -> detalleCompraService.modificarDetalleCompra(detalleCompra.getIdDetalleCompra(), detalleCompra)
        ).collect(Collectors.toList());
        compraIN.setDetalles(detallesBD);
        Compra compraBD = compraService.modificarCompra(id, compraIN);

        return new ResponseEntity<>(compraBD, HttpStatus.OK);
    }
}
