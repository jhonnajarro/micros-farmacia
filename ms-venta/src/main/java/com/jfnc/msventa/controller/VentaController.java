package com.jfnc.msventa.controller;

import com.jfnc.msventa.entity.DetalleVenta;
import com.jfnc.msventa.entity.Venta;
import com.jfnc.msventa.model.ResponseProducto;
import com.jfnc.msventa.service.DetalleVentaService;
import com.jfnc.msventa.service.VentaService;
import com.jfnc.msventa.service.impl.ApiUsuarioExtImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @Autowired
    DetalleVentaService detalleVentaService;

    @Autowired
    private ApiUsuarioExtImpl apiUsuarioExt;

    @GetMapping("/listarVentas")
    public ResponseEntity<List<Venta>> listar(){
        List<Venta> ventas= ventaService.listarVenta();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/obtenerProductoOfVentas")
    public ResponseProducto obtenerProducto(@RequestParam(required = true) Long id) {
        return apiUsuarioExt.obtenerProducto(id);
    }

}
