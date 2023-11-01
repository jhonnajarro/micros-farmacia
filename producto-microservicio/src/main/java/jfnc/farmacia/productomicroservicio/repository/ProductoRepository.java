package jfnc.farmacia.productomicroservicio.repository;

import jfnc.farmacia.productomicroservicio.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
