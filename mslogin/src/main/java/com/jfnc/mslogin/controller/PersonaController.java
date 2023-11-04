package com.jfnc.mslogin.controller;


import com.jfnc.mslogin.entity.Persona;
import com.jfnc.mslogin.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/listarPersona")
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> personas=personaService.listarPersona();
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }

    @GetMapping("/personaPorId/{id}")
    public ResponseEntity<Persona> personaPorId(@PathVariable Long id ){
        Persona persona=personaService.personaPorId(id);
        return new ResponseEntity<>(persona,HttpStatus.OK);
    }

    @PostMapping("/registrarPersona")
    public ResponseEntity<Persona> guardar(@RequestBody Persona persona){
        Persona personaBD=personaService.creaPersona(persona);
        return new ResponseEntity<>(personaBD, HttpStatus.CREATED);
    }

    @PutMapping("/modificarPersona/{id}")
    public ResponseEntity<Persona> modificar(@PathVariable Long id, @RequestBody Persona persona){
        Persona personaBD= personaService.modificarPersona(id,persona);
        return new ResponseEntity<>(personaBD,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPersona/{id}")
    public ResponseEntity<Persona> eliminar(@PathVariable Long id){
        Persona persona=personaService.eliminarPersona(id);
        return new ResponseEntity<>(persona,HttpStatus.OK);
    }



}
