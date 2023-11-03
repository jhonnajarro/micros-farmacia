package com.jfnc.mscompras.dto;

import com.jfnc.mscompras.entity.DetalleCompra;
import com.jfnc.mscompras.entity.Proveedor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDTO {
    private Proveedor proveedor;

    private List<DetalleCompra> detalles;

}
