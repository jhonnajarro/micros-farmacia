package com.jfnc.mslogin.service;

import com.jfnc.mslogin.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario) throws Exception;

    List<Usuario> listarUsuario();

    Usuario usuarioPorId(Long id);

    Usuario modificarUsuario(Long id, Usuario usuario);

    Usuario eliminarUsuario(Long id);
}
