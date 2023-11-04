package com.jfnc.mslogin.service.impl;

import com.jfnc.mslogin.entity.Persona;
import com.jfnc.mslogin.repository.PersonaRepository;
import com.jfnc.mslogin.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona creaPersona(Persona persona) {
                persona.setEstado(1);
                persona.setFechaCrea(new Date());
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> listarPersona() {
            List<Persona> personas= personaRepository.findAllByEstado(1);
        return personas;
    }

    @Override
    public Persona personaPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona modificarPersona(Long id, Persona persona) {
        if(personaRepository.existsById(id)){
            persona.setFechaMod(new Date());
            return personaRepository.save(persona);
        }
        return null;
    }

    @Override
    public Persona eliminarPersona(Long id) {
        if(personaRepository.existsById(id)){
            Persona persona=personaRepository.findById(id).orElse(null);
            persona.setEstado(0);
            persona.setFechaMod(new Date());
            return personaRepository.save(persona);
        }
        return null;
    }
}
