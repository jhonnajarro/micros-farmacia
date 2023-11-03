package com.jfnc.mscompras.service;

import com.jfnc.mscompras.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    Proveedor crearProveedor(Proveedor proveedor);

    List<Proveedor> listarProveedor();

    Proveedor proveedorPorId(Long id);

    Proveedor modificarProveedor(Long id, Proveedor proveedor);

    Proveedor eliminarProveedor(Long id);
}
