package jfnc.farmacia.productomicroservicio.controller;

import jfnc.farmacia.productomicroservicio.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private  ProductoService productoService;




}
