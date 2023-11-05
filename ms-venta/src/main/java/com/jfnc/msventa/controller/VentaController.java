package com.jfnc.msventa.controller;

import com.jfnc.msventa.dto.VentaDTO;
import com.jfnc.msventa.entity.DetalleVenta;
import com.jfnc.msventa.entity.Venta;
import com.jfnc.msventa.model.ResponseProducto;
import com.jfnc.msventa.service.DetalleVentaService;
import com.jfnc.msventa.service.VentaService;
import com.jfnc.msventa.service.impl.ApiUsuarioExtImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @Autowired
    DetalleVentaService detalleVentaService;

    @Autowired
    private ApiUsuarioExtImpl apiUsuarioExt;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/listarVentas")
    public ResponseEntity<List<Venta>> listar(){
        List<Venta> ventas= ventaService.listarVenta();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/obtenerProductoOfVentas")
    public ResponseProducto obtenerProducto(@RequestParam(required = true) Long id) {
        return apiUsuarioExt.obtenerProducto(id);
    }

    @GetMapping("/ventaPorId/{id}")
    public ResponseEntity<Venta> ventaPorId(@PathVariable Long id){
        Venta venta= ventaService.ventaPorId(id);
        return new ResponseEntity<>(venta,HttpStatus.OK);
    }

    @PostMapping("/guardarVenta")
    public ResponseEntity<Venta> guardar(@RequestBody VentaDTO ventaDTO){
        Venta ventaIN=modelMapper.map(ventaDTO,Venta.class);
        List<DetalleVenta> detalles= ventaIN.getListVentas();
        List<DetalleVenta> detalleVentas=detalles.stream().map(detalleVenta -> detalleVentaService.crearDetalleVenta(detalleVenta)).collect(Collectors.toList());
        ventaIN.setListVentas(detalleVentas);
        Venta ventaBD=ventaService.crearVenta(ventaIN);
        return new ResponseEntity<>(ventaBD, HttpStatus.CREATED);
    }

    @PutMapping("/modificarVenta/{id}")
    public ResponseEntity<Venta> modificar(@PathVariable Long id,@RequestBody VentaDTO ventaDTO){
        Venta ventaIN=modelMapper.map(ventaDTO,Venta.class);
        List<DetalleVenta> detalles=ventaIN.getListVentas();

        List<DetalleVenta> detalleVentas=detalles.stream().map(detalleVenta -> detalleVentaService.modificarDetalleVenta(detalleVenta,detalleVenta.getIdDetalleVenta())).collect(Collectors.toList());
        ventaIN.setListVentas(detalleVentas);
        Venta ventaBD=ventaService.modificarVenta(ventaIN, ventaIN.getIdVenta());
        return new ResponseEntity<>(ventaBD,HttpStatus.OK);
    }


}
