package com.jfnc.mscompras.repository;

import com.jfnc.mscompras.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
    List<Compra> findAllByEstado(int estado);
}
