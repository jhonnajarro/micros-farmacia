package jfnc.farmacia.productomicroservicio.repository;

import jfnc.farmacia.productomicroservicio.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenReporitory extends JpaRepository<Almacen,Long> {
}
