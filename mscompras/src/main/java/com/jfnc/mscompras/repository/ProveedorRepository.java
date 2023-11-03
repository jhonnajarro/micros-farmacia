package com.jfnc.mscompras.repository;

import com.jfnc.mscompras.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {

    List<Proveedor> findAllByEstado(int estado);
}
