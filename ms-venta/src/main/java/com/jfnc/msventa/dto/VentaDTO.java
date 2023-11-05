package com.jfnc.msventa.dto;

import com.jfnc.msventa.entity.DetalleVenta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VentaDTO {

    private Long idVenta;
    private Date fechaVenta;
    private Long idCliente;
    private Long idUsuario;
    private List<DetalleVenta> listVentas;
}
