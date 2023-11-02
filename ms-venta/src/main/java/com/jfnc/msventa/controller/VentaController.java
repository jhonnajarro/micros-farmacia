package com.jfnc.msventa.controller;

import com.jfnc.msventa.entity.DetalleVenta;
import com.jfnc.msventa.entity.Venta;
import com.jfnc.msventa.service.DetalleVentaService;
import com.jfnc.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @Autowired
    DetalleVentaService detalleVentaService;

    @GetMapping("/listarVentas")
    public ResponseEntity<List<Venta>> listar(){
        List<Venta> ventas= ventaService.listarVenta();
        return ResponseEntity.ok(ventas);
    }
}
