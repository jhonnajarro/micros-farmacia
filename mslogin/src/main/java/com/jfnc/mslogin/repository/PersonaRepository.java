package com.jfnc.mslogin.repository;

import com.jfnc.mslogin.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    List<Persona> findAllByEstado(int estado);
}
