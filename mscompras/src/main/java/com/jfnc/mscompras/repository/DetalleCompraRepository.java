package com.jfnc.mscompras.repository;

import com.jfnc.mscompras.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra,Long> {
}
