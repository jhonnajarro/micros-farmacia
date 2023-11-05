package com.jfnc.mslogin.controller;

import com.jfnc.mslogin.entity.Usuario;
import com.jfnc.mslogin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<Usuario>> lista(){
        List<Usuario> usuarios=usuarioService.listarUsuario();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }

    @GetMapping("/usuarioPorId")
    public ResponseEntity<Usuario> usuarioPorId(@RequestParam Long id){
        Usuario usuario= usuarioService.usuarioPorId(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }

    @PostMapping("/registrarUsuario")
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario)throws Exception{
     Usuario usuarioBD= usuarioService.crearUsuario(usuario);
     return new ResponseEntity<>(usuarioBD, HttpStatus.CREATED);
    }

    @PutMapping("/modificarUsuario/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioBD= usuarioService.modificarUsuario(id,usuario);
        return new ResponseEntity<>(usuarioBD,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuario")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id){
        Usuario usuario= usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }
}
