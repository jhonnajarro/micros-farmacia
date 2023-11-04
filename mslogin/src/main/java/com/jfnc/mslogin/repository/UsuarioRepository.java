package com.jfnc.mslogin.repository;

import com.jfnc.mslogin.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    List<Usuario> findAllByEstado(int estado);
}
