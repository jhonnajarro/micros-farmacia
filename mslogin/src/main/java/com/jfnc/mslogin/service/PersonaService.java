package com.jfnc.mslogin.service;

import com.jfnc.mslogin.entity.Persona;

import java.util.List;

public interface PersonaService {

    Persona creaPersona(Persona persona);

    List<Persona> listarPersona();

    Persona personaPorId(Long id);

    Persona modificarPersona(Long id, Persona persona);

    Persona eliminarPersona(Long id);

}
