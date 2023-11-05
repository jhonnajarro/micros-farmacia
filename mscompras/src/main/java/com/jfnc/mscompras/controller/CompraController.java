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


    @PostMapping("/registrarCompra")
    public ResponseEntity<Compra> guardar(@RequestBody CompraDTO compraDTO){
        Compra compraIN= modelMapper.map(compraDTO,Compra.class);
        List<DetalleCompra> detalles= compraDTO.getDetalles();

        List<DetalleCompra> detallesBD=detalles.stream().map(detalleCompra -> detalleCompraService.crearDetalleCompra(detalleCompra)).collect(Collectors.toList());
        compraIN.setDetalles(detallesBD);
        Compra compraBD=compraService.crearCompra(compraIN);

        return new ResponseEntity<>(compraBD, HttpStatus.CREATED);
    }

}
