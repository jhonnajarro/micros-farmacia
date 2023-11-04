package com.jfnc.mslogin.repository;

import com.jfnc.mslogin.entity.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPersonaRepository extends JpaRepository<TipoPersona,Long> {
}
