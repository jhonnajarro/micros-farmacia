package com.jfnc.mscompras.controller;

import com.jfnc.mscompras.dto.CompraDTO;
import com.jfnc.mscompras.entity.Compra;
import com.jfnc.mscompras.entity.DetalleCompra;
import com.jfnc.mscompras.repository.CompraRepository;
import com.jfnc.mscompras.service.CompraService;
import com.jfnc.mscompras.service.DetalleCompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/registrarCompra")
    public ResponseEntity<Compra> guardar(@RequestBody CompraDTO compraDTO){
        Compra compraIN= modelMapper.map(compraDTO,Compra.class);
        List<DetalleCompra> detalles= compraDTO.getDetalles();
        System.out.println("LA LISTA DE DETALLES ES  ::::::::::::::::::: "+compraIN.getDetalles());
        List<DetalleCompra> detallesBD=detalles.stream().map(detalleCompra -> detalleCompraService.crearDetalleCompra(detalleCompra)).collect(Collectors.toList());
        compraIN.setDetalles(detallesBD);
        Compra compraBD=compraService.crearCompra(compraIN);

        return new ResponseEntity<>(compraBD, HttpStatus.CREATED);
    }

}
