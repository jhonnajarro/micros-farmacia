package com.jfnc.mscompras.controller;

import com.jfnc.mscompras.entity.Proveedor;
import com.jfnc.mscompras.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/listarProveedor")
    public ResponseEntity<List<Proveedor>> listar(){
        List<Proveedor> proveedors =proveedorService.listarProveedor();
        return new ResponseEntity<>(proveedors,HttpStatus.OK);
    }

    @GetMapping("/proveedorPorId/{id}")
    public ResponseEntity<Proveedor> proveedorPorId(@PathVariable Long id ){
        Proveedor proveedor = proveedorService.proveedorPorId(id);
        return new ResponseEntity<>(proveedor,HttpStatus.OK);
    }

    @PostMapping("/registrarProveedor")
    public ResponseEntity<Proveedor> guardar(@RequestBody Proveedor proveedor){
            Proveedor proveedorBD=proveedorService.crearProveedor(proveedor);
            return new ResponseEntity<>(proveedorBD, HttpStatus.CREATED);
    }

    @PutMapping("/modificarProveedor/{id}")
    public ResponseEntity<Proveedor> modificar(@PathVariable Long id, @RequestBody Proveedor proveedor ){
        Proveedor proveedorBD= proveedorService.modificarProveedor(id,proveedor);
        return new ResponseEntity<>(proveedorBD,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarProveedor/{id}")
    public ResponseEntity<Proveedor> eliminar(@PathVariable Long id){
        Proveedor proveedorEliminado = proveedorService.eliminarProveedor(id);
        return new ResponseEntity<>(proveedorEliminado,HttpStatus.OK);
    }
}
