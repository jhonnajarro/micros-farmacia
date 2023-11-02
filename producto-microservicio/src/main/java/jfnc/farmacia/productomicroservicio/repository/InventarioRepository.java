package jfnc.farmacia.productomicroservicio.repository;

import jfnc.farmacia.productomicroservicio.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long> {
}
